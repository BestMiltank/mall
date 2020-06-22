package com.miltank.productclient.feign.fallback;

import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.productclient.feign.FileClient;
import org.springframework.stereotype.Component;

/**
 * @author shenjj
 * @date 2020-06-22 16:26
 */
@Component
public class FileServiceHystrix implements FileClient {
    @Override
    public void addFileInfo(FileInfo fileInfo) {
        System.out.println("error");
    }
}
