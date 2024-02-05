package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        // 把文件的內容儲存到本地磁碟
        String originalFilename = file.getOriginalFilename();
        // 透過UUID保證文件名唯一，防止文件覆蓋
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
//        file.transferTo(new File("C:\\Users\\user\\Desktop\\files\\"+filename));
        // 把文件內容儲存到阿里雲上
        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
