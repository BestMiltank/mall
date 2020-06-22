package com.miltank.fileclient.controller;

import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.fileclient.service.interfaces.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;


/**
 * @author shenjj
 * @date 2020-06-09 17:31
 */
@Api(tags = "文件")
@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传", notes = "文件上传")
    public String uploadFile(@RequestBody MultipartFile file) {
        return fileService.uploadFile(file);
    }

    @GetMapping("/download/{id}")
    @ApiOperation(value = "文件下载", notes = "文件下载")
    public void downloadFile(@PathVariable String id, HttpServletResponse response) {
        fileService.getObject("file", id, response);
    }

    @PostMapping
    @ApiOperation(value = "插入存储记录", notes = "插入存储记录")
    public void addFileInfo(@RequestBody FileInfo fileInfo){
        fileService.save(fileInfo);
    }
}
