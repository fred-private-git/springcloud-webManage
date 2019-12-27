package com.zkml.official_facade.service;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.qiniu.support.FileOperateResult;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by fanghui on 2019/4/23.
 */
public interface FileFacadeService {

    /**
     * 获取七牛上传凭证
     * @return
     */
    ResultModelDTO getUploadToken();

    /**
     * 上传图片
     * @param request
     * @param type
     * @return
     */
    ResultModelDTO uploadImage(HttpServletRequest request, String type);

    /**
     * 上传base64文件流
     * @param base64EncodedImage
     * @param fileName
     * @return
     */
    FileOperateResult uploadBase64File(String base64EncodedImage, String fileName) throws IOException;
}
