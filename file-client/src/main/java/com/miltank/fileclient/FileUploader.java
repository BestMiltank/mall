package com.miltank.fileclient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;

import org.xmlpull.v1.XmlPullParserException;

import io.minio.MinioClient;
import io.minio.errors.MinioException;

public class FileUploader {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient("http://47.103.22.99:9000", "admin", "12345678");

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists("miltank");
            if (isExist) {
                System.out.println("Bucket already exists.");
            } else {
                // 创建一个名为asiatrip的存储桶，用于存储照片的zip文件。
                minioClient.makeBucket("miltank");
            }

            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject("miltank", "asiaphotos.zip", "D:\\points.txt");
            InputStream is = new FileInputStream("");
        } catch (MinioException e) {
            System.out.println("Error occurred: " + e);
        }
    }
}