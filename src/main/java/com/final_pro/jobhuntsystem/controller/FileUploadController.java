package com.final_pro.jobhuntsystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    // http://localhost:8088/upload
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException{
        // 传递参数：用户的昵称、用户的头像、网络请求对象（Java EE提供的原始类，传参时不用管）

        // 打印昵称
        System.out.println(nickname);
        // 获取图片原始名称
        System.out.println(photo.getOriginalFilename());
        // 取文件类型
        System.out.println(photo.getContentType());

        // 关键：获取请求所属的上下文对象(Web服务器)，再获取服务器运行的目录(目前是本地，将来要部署到云端)
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);
        return "上传成功！";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException{
        // 判断存储的目录是否存在
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdir();
        }

        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
