package com.miltank.fileclient.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miltank.fileclient.pojo.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService extends IService<FileInfo> {
    String uploadFile(MultipartFile file);

    void getObject(String bucketName, String objectName, HttpServletResponse response);

    String getObjectURL(String bucketName, String objectName, Integer expires);
}
