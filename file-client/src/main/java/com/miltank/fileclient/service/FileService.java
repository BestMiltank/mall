package com.miltank.fileclient.service;

import com.miltank.fileclient.mapper.FileMapper;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

@Service
public class FileService {
    @Autowired
    private MinioClient client;

    public String uploadFile(MultipartFile file) {
        try {
            String id = UUID.randomUUID().toString();
            client.putObject("file", id, file.getInputStream(), file.getSize(), file.getContentType());
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public InputStream getObject(String bucketName, String objectName) throws Exception{
        return client.getObject(bucketName, objectName);
    }

    public String getObjectURL(String bucketName, String objectName, Integer expires){
        try {
            return client.presignedGetObject(bucketName, objectName, expires);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
