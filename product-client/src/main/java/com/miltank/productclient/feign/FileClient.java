package com.miltank.productclient.feign;

import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.productclient.feign.fallback.FileServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "file-client",fallback = FileServiceHystrix.class)
public interface FileClient {

    @PostMapping(value = "/file")
    void addFileInfo(@RequestBody FileInfo fileInfo);
}
