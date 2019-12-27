package com.zkml.official_facade.service.impl;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.service.FileFacadeService;
import com.zkml.official_reception.client.enums.CustResultCodeEnum;
import com.zkml.qiniu.support.FileOperateResult;
import com.zkml.qiniu.support.FileValidateException;
import com.zkml.qiniu.support.cloud.QiNiuFileCloud;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fanghui on 2019/4/23.
 */

@Service
@Slf4j
public class FileFacadeServiceImpl implements FileFacadeService {

    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucketName}")
    private String bucketName;
    @Value("${qiniu.bucketURL}")
    private String bucketURL;

    @Autowired
    QiNiuFileCloud qiNiuFileCloud;

    /**
     * 上传七牛凭证
     * @return
     */
    @Override
    public ResultModelDTO getUploadToken() {

        com.alibaba.fastjson.JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        Mac mac = new Mac(accessKey, secretKey);
        PutPolicy putPolicy = new PutPolicy(bucketName);
        try {
            String upToken = null;
            upToken = putPolicy.token(mac);
            jsonObject.put("token", upToken);
            jsonObject.put("upUrl","http://pics.govicar.com/");
            jsonObject.put("fileName", UUID.randomUUID().toString());
            return ResultModelUtil.successResult(jsonObject);
        } catch (AuthException e) {
            log.error("获取七牛云上传凭证失败1:{},{}",e.getMessage(),e);
        } catch (JSONException e) {
            log.error("获取七牛云上传凭证失败2:{},{}",e.getMessage(),e);
        }
        return ResultModelUtil.successResult(CustResultCodeEnum.GET_TOKEN_ERROR);
    }

    /**
     * 上传图片
     * @param request
     * @param type
     * @return
     */
    @Override
    public ResultModelDTO uploadImage(HttpServletRequest request, String type) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String imgFile = "";
        String[] suffix = new String[5];
        if("image/png".equals(type) || "image/jpg".equals(type) || "image/jpeg".equals(type)|| "image/bmp".equals(type) || "imgFile".equals(type)|| type==null){
            imgFile = "imgFile";
            suffix[0] = "png";
            suffix[1] = "jpg";
            suffix[2] = "jpeg";
            suffix[3] = "bmp";
            suffix[4] = "";
        }else{
            imgFile = "file";
            suffix[0] = "dwg";
            suffix[1] = "doc";
            suffix[2] = "docx";
            suffix[3] = "xls";
            suffix[4] = "xlsx";
        }
        long fileMaxSize = 1024*1024*30;
        FileOperateResult fileOperateResult =  null;
        Map<String,String> urlMap = new HashMap<String,String>();
        String message = "";
        String result = "";
        String url = "";
        try {
            fileOperateResult = qiNiuFileCloud.upload(multipartRequest, imgFile, suffix, fileMaxSize);
            if(fileOperateResult.isSuccess()) {
                message = "上传成功";
                result = "success";
                url = fileOperateResult.getNewFileURL();
                return ResultModelUtil.successResult(CustResultCodeEnum.IMAGE_SUCCESS,url);
            } else {
                message = "上传失败";
                result = "fail";
                return ResultModelUtil.failResult(CustResultCodeEnum.IMAGE_ERROR);
            }
        }  catch (FileValidateException e) {
            message = e.getMessage();
            result = "fail";
            return ResultModelUtil.failResult(CustResultCodeEnum.IMAGE_ERROR);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            message = "上传失败";
            result = "fail";
            return ResultModelUtil.failResult(CustResultCodeEnum.IMAGE_ERROR);
        }
    }

    @Override
    public FileOperateResult  uploadBase64File(String base64EncodedImage, String fileName) throws IOException {
        //base64EncodedImage.indexOf("")
        if(base64EncodedImage != null && base64EncodedImage.length() != 0) {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] base64EncodedImageBytes = decoder.decodeBuffer(base64EncodedImage);

            for(int i = 0; i < base64EncodedImageBytes.length; ++i) {
                if(base64EncodedImageBytes[i] < 0) {
                    base64EncodedImageBytes[i] = (byte)(base64EncodedImageBytes[i] + 256);
                }
            }
            ByteArrayInputStream inputStream = null;
            FileOperateResult var10 = null;
            try {
                inputStream = new ByteArrayInputStream(base64EncodedImageBytes);
                FileOperateResult result = new FileOperateResult();
                Mac mac = new Mac(accessKey, secretKey);
                PutPolicy putPolicy = new PutPolicy(bucketName);
                String upToken = putPolicy.token(mac);
                PutExtra extra = new PutExtra();
                String finalFileName = "";
                if(StringUtils.isEmpty(fileName)){
                    finalFileName = UUID.randomUUID().toString();
                }else{
                    finalFileName = UUID.randomUUID()+fileName;
                }
                String key = finalFileName + ".jpg";
                PutRet ret = IoApi.Put(upToken, key, inputStream, extra);
                if(ret.ok()) {
                    result.setSuccess(true);
                    result.setNewFileURL(bucketURL+key);
                } else {
                    result.setSuccess(false);
                }

                var10 = result;
            } catch (AuthException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
            return var10;
        } else {
            throw new IllegalArgumentException("参数base64EncodedImage内容不能为空");
        }

    }
}
