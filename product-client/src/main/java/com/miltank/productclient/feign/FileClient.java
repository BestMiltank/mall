package com.miltank.productclient.feign;

import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.productclient.feign.fallback.FileServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "file-client",fallback = FileServiceHystrix.class)
public interface FileClient {

    @PostMapping(value = "/file")
    void addFileInfo(@RequestBody FileInfo fileInfo);

    @PostMapping(value = "/file/list")
    void addFileInfo(@RequestBody List<FileInfo> files);

    @GetMapping(value = "/file")
    List<FileInfo> queryRelationFiles(String className, String relationId);
}
