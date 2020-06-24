package com.miltank.productclient.feign.fallback;

import com.miltank.fileclient.pojo.FileInfo;
import com.miltank.productclient.feign.FileClient;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public void addFileInfo(List<FileInfo> files) {
        System.out.println("error");
    }

    @Override
    public List<FileInfo> queryRelationFiles(String className, String relationId) {
        return null;
    }
}
