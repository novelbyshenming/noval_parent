package controller;

import MyException.UploadException;
import bean.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.UploadService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author LX
 * @date 2019/5/1 - 18:19
 */
@Controller
public class UploadController {

    @Autowired
    private UploadService uploadServiceImpl;

    
    
    
    @ResponseBody
    @RequestMapping("upload.u")
    public String upload(User user, MultipartFile fileName){
        // 返回给上传页面的结果信息  默认为 上传成功
        String message = "上传成功";
        try {

        String filename = fileName.getOriginalFilename();

        String fileType = filename.substring( filename.lastIndexOf(".") );

        if(fileType.equalsIgnoreCase(".png") ||fileType.equalsIgnoreCase(".jpg") ){

            // 文件存放的路径   注意  图片是通过 nginx静态传递的 没有放到  tomcat服务器中
            String filePath = "D:/images";

            String head = UUID.randomUUID().toString() + fileType;

                InputStream fileNameInputStream = fileName.getInputStream();

                File file = new File(filePath,head);

                FileUtils.copyInputStreamToFile(fileNameInputStream,file);

                user.setHead("images"+"/"+head);

                uploadServiceImpl.updUser(user);
        }else{

            throw new UploadException("上传图片的格式不正确");
        }

        } catch (IOException e) {

            message = "文件传输失败";
        } catch (UploadException e) {

            message = e.getMessage();
        }

        return message;
    }

}
