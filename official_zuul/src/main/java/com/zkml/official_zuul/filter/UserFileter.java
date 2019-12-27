package com.zkml.official_zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zkml.official_zuul.utils.HttpUtil;
import com.zkml.sso_api.api.SSOClientApi;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ysyang on 2019/3/25.
 */
public class UserFileter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(UserFileter.class);
    @Value("${user.authPrefixUrl}")
    private String authPrefixUrl;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("shouldFile()");
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        logger.info("进入过滤....");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        if(!request.getRequestURI().startsWith("/api") && !request.getRequestURI().startsWith("/officialfacade")){
            return null;
        }
        HttpServletResponse response = currentContext.getResponse();
        HttpSession session = request.getSession();
        String token = request.getParameter("token");
        logger.info("获取用户token:{}", token);
        Map<String, String> paramAlive = new HashMap<>();
        paramAlive.put("token", token);
        //验证是否登录
        Boolean isLogin = (Boolean) session.getAttribute("isLogin");
        if (isLogin != null && isLogin) {
            logger.info("刷新token时间");
            //已登录，继续向后调用
            try {
                String userInfoDTO = (String) session.getAttribute("userInfoDTO");
                currentContext.addZuulRequestHeader("userInfoDTO", userInfoDTO);
                String result = HttpUtil.sendHttpRequest(authPrefixUrl + SSOClientApi.SSO_KEEPALIVE_URL, paramAlive);
                logger.info("刷新token时间接口返回...{}", result);
                return null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //去认证中心验证token是否合法
        if (!org.springframework.util.StringUtils.isEmpty(token)) {
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
            Map<String, String> params = new HashMap<>();
            params.put("token", token);
            params.put("sessionId", session.getId());
            params.put("logoutUrl", basePath + "/logout");

            Map<String, String> paramToken = new HashMap<>();
            paramToken.put("token", token);
            try {
                String isVerify = HttpUtil.sendHttpRequest(authPrefixUrl + SSOClientApi.SSO_VERIFY_TOKEN_URL, params);
                JSONObject jsonObject = (JSONObject) JSONObject.parse(isVerify);
                boolean login = (boolean) jsonObject.get("isVerify");
                if (login) {
                    session.setAttribute("isLogin", true);
                    String userInfoDTO = jsonObject.getString("userInfoDTO");
                    logger.info("未登录情况下..验证token获取的user:" + userInfoDTO);
                    session.setAttribute("userInfoDTO", userInfoDTO);
                    currentContext.addZuulRequestHeader("userInfoDTO", userInfoDTO.toString());
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");
            writer = response.getWriter();
            Map<String, String> map = new HashMap<>();
            logger.info("用户未登录...");
            map.put("code", String.valueOf(401));
            map.put("result", "fail");
            map.put("message", "未登录，请重新登录");
            writer.write(JSONObject.toJSONString(map));
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.SC_ACCEPTED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
