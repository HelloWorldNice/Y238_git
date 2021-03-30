package cn.bdqn.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RestController
public class UploadController {

    @PostMapping("/upload")
    public String upload(
            HttpServletRequest request,
            @RequestParam(name = "touxiang") MultipartFile file)
            throws Exception
    {

        String path = request.getServletContext().getRealPath("/upload");
        File parentPath = new File(path);
        if (!parentPath.exists()){
            parentPath.mkdirs();
        }

        // 1、获取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 2、实现文件上传
        file.transferTo(new File(parentPath , originalFilename));

        return "success";
    }
}
