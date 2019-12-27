package com.zkml.official_zuul.controller;

import com.alibaba.fastjson.JSONObject;
import com.zkml.common.util.MyUtil;
import com.zkml.official_zuul.utils.HttpUtil;
import com.zkml.sso_api.api.SSOClientApi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@Api(tags = "登录接口相关服务")
@RequestMapping("/reception")
public class LoginController {
    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Value("${user.authPrefixUrl}")
    private String authPrefixUrl;

    /**
     * 登录操作
     * @param username
     * @param password
     * @param request
     * @param model
     * @param response
     * @return
     */
    @RequestMapping(value = "/doLogin")
    @ApiOperation("登录")
    @ResponseBody
    public Map<String,Object> login(String username, String password, HttpServletRequest request, Model model, HttpServletResponse response){
        logger.info("进入登录doLogin方法......");
        logger.info("登录入参userName与password:{} {}",username,password);
        HttpSession session = request.getSession();
        Map<String,String> params = new HashMap<>();
        Map<String,String> paramToken = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        String loginApiUrl = authPrefixUrl+ SSOClientApi.SSO_LOGIN_API_URL;
        String findUserInfoUrl = authPrefixUrl+SSOClientApi.SSO_FIND_USER_INFO_URL;
        try{
            String result = HttpUtil.sendHttpRequest(loginApiUrl,params);
            JSONObject jsonObject =(JSONObject) JSONObject.parse(result);
            System.out.println(jsonObject);
            String code = jsonObject.getString("code");
            if("success".equals(code)){
                resultMap.put("code","200");
                String token = jsonObject.getString("token");
                paramToken.put("token",token);
                String userInfo = HttpUtil.sendHttpRequest(findUserInfoUrl,paramToken);
                JSONObject userInfoObject =(JSONObject) JSONObject.parse(userInfo);
                resultMap.put("data",userInfoObject);
                resultMap.put("token",token);
                resultMap.put("result","success");
                resultMap.put("message","成功");
            }else{
                resultMap.put("result","fail");
                resultMap.put("code",String.valueOf(401));
                String errorMessage = jsonObject.getString("errorMessage");
                resultMap.put("message",errorMessage);
                resultMap.put("data","");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }


    @RequestMapping(value = "/userInfo")
    @ResponseBody
    public Map<String,Object> getUserInfo(String token, Model model, HttpServletResponse response){
        logger.info("获取用户信息入参token:{}",token);
        Map<String,String> paramToken = new HashMap<>();
        paramToken.put("token",token);
        Map<String,Object> resultMap = new HashMap<String,Object>();
        if(MyUtil.isBlank(token)){
            logger.info("token不能为空");
            resultMap.put("token",token);
            resultMap.put("result","fail");
            resultMap.put("code",String.valueOf(401));
            resultMap.put("message","失败");
            return resultMap;
        }
        String findUserInfoUrl = "http://192.168.15.215:9090"+SSOClientApi.SSO_FIND_USER_INFO_URL;
        try{
            String userInfo = HttpUtil.sendHttpRequest(findUserInfoUrl,paramToken);
            JSONObject userInfoDTO =(JSONObject) JSONObject.parse(userInfo);
            resultMap.put("token",token);
            resultMap.put("result","success");
            resultMap.put("code",String.valueOf(200));
            resultMap.put("message","成功");
            resultMap.put("userInfoDTO",userInfoDTO);
        }catch (Exception e){
            resultMap.put("token",token);
            resultMap.put("result","fail");
            resultMap.put("code",String.valueOf(401));
            resultMap.put("message","失败");
            e.printStackTrace();
        }
        return resultMap;
    }

    @RequestMapping("/logOut")
    @ResponseBody
    public Map<String,Object> logOut(HttpSession session,String token){
        String logoutUrl = "http://192.168.15.215:9090"+SSOClientApi.SSO_LOGOUT_URL;
        logger.info("退出接口入参token:{}",token);
        Map<String,String> paramToken = new HashMap<>();
        paramToken.put("token",token);
        session.invalidate();
        logger.info("session已经清除...");
        Map<String,Object> resultMap = new HashMap<String,Object>();
        try {
            String result = HttpUtil.sendHttpRequest(logoutUrl,paramToken);
            if("success".equals(result)){
                resultMap.put("code","200");
                resultMap.put("result","success");
                resultMap.put("message","成功");
            }else{
                resultMap.put("code",String.valueOf(401));
                resultMap.put("result","fail");
                resultMap.put("message","失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("code",String.valueOf(401));
            resultMap.put("result","fail");
            resultMap.put("message","失败");
        }
        return resultMap;
    }
}
