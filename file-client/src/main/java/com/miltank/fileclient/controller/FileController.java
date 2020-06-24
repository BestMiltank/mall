package com.miltank.fileclient.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.fileclient.service.interfaces.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public void addFileInfo(@RequestBody FileInfo fileInfo) {
        fileService.save(fileInfo);
    }

    @PostMapping("/list")
    public void addFileInfo(@RequestBody List<FileInfo> files) {
        fileService.saveBatch(files);
    }

    @GetMapping
    @ApiOperation(value = "文件记录", notes = "文件记录")
    public List<FileInfo> queryRelationFiles(String className, String relationId) {
        QueryWrapper<FileInfo> wrappers = new QueryWrapper<>();
        wrappers.eq("class_name", className)
                .eq("relation_id", relationId);
        return fileService.list(wrappers);
    }
}
