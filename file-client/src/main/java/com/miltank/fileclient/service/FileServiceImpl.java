package com.miltank.fileclient.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miltank.fileclient.mapper.FileMapper;
import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.fileclient.service.interfaces.FileService;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.UUID;

@Service
@Transactional
public class FileServiceImpl extends ServiceImpl<FileMapper,FileInfo> implements FileService {
    @Autowired
    private MinioClient client;

    public String uploadFile(MultipartFile file) {
        try {
            String originalname = file.getOriginalFilename();
            String form = "";
            if (originalname != null) {
                int index = originalname.lastIndexOf(".");
                if (index > 0) form = originalname.substring(index);
                else form = "";
            }
            String id = UUID.randomUUID().toString();
            client.putObject("file", id + form, file.getInputStream(), new PutObjectOptions(file.getInputStream().available(), -1));
            return id + form;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void getObject(String bucketName, String objectName, HttpServletResponse response) {
        try {
            InputStream inputStream = client.getObject(bucketName, objectName);
            int b = 0;
            byte[] buffer = new byte[512];
            ServletOutputStream out = response.getOutputStream();
            while (b != -1) {
                b = inputStream.read(buffer);
                out.write(buffer, 0, b);
            }
            inputStream.close();
            out.close();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getObjectURL(String bucketName, String objectName, Integer expires) {
        try {
            return client.presignedGetObject(bucketName, objectName, expires);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
