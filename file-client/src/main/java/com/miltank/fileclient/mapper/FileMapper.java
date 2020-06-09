package com.miltank.fileclient.mapper;

import com.miltank.fileclient.pojo.FileInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {
    public void uploadFile(FileInfo fileInfo);
}
