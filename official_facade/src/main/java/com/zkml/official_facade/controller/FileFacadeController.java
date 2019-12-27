package com.zkml.official_facade.controller;

import com.zkml.common.obj.dto.ResultModelDTO;
import com.zkml.common.obj.util.ResultModelUtil;
import com.zkml.official_facade.exception.OfficialException;
import com.zkml.official_facade.service.FileFacadeService;
import com.zkml.qiniu.support.FileOperateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * 图片上传
 */
@RestController
@RequestMapping("/file")
public class FileFacadeController {

    @Autowired
    FileFacadeService fileFacadeService;

    /**
     * 上传图片
     * @param request
     * @param type
     * @return
     */
    @RequestMapping("/uploadImage")
    public ResultModelDTO uploadImage(HttpServletRequest request , String type) {
        try {
            return fileFacadeService.uploadImage(request,type);
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    /**
     * 获取七牛上传凭证
     * @return
     */
    @RequestMapping("/getUploadToken")
    public ResultModelDTO getUploadToken(){
        try {
            return fileFacadeService.getUploadToken();
        }catch (OfficialException officialException){
            return ResultModelUtil.failResult(officialException);
        }
    }

    /**
     * 上传base64文件流
     * @return
     */
    @RequestMapping("/uploadBase64File")
    public FileOperateResult uploadBase64File(String base64EncodedImage, String fileName)throws IOException{
        return fileFacadeService.uploadBase64File(base64EncodedImage,fileName);
    }

    public static void main(String[] args) throws Exception {
        String base64 = "";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\aaaaa.txt")));
        String line = null;
        while((line=bufferedReader.readLine())!=null){
            base64+=line;
        }
        toPDF(base64);
    }

    public static  void toPDF(String str )throws Exception{
        String base64Content= str ;
        String filePath="D:\\allin\\tdtd.jpg";
        BASE64Decoder decoder = new BASE64Decoder();
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            byte[] bytes = decoder.decodeBuffer(base64Content);//base64编码内容转换为字节数组
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            File path = file.getParentFile();
            if(!path.exists()){
                path.mkdirs();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while(length != -1){
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
            System.out.println("compleet");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        }
    }

    public static String toBase64() throws FileNotFoundException {
        BASE64Encoder encoder = new BASE64Encoder();
        FileInputStream fin =null;
        BufferedInputStream bin =null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout =null;
        try {
            fin = new FileInputStream(new File("D:\\维老板.txt"));
            bin = new BufferedInputStream(fin);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while(len != -1){
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            //刷新此输出流并强制写出所有缓冲的输出字节
            bout.flush();
            byte[] bytes = baos.toByteArray();
            System.out.println(encoder.encodeBuffer(bytes).trim());
            return encoder.encodeBuffer(bytes).trim();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fin.close();
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

}
