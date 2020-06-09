package com.miltank.fileclient.controller;

import com.sun.xml.internal.bind.v2.TODO;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author shenjj
 * @date 2020-06-09 17:31
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private MinioClient client;

    @PostMapping("/upload")
    public String uploadFile(@RequestBody MultipartFile file) {
        try {
            client.putObject("", "", file.getInputStream(), file.getSize(), file.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO: 2020/6/9 add to db
        return null;//return id
    }
}
