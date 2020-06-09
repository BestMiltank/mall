package com.miltank.fileclient.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shenjj
 * @date 2020-06-09 17:04
 */
@Configuration
public class MinioConfig {
    @Value("${minio.endPoint}")
    private String endPoint;
    @Value(("${minio.accessKey}"))
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient initMinio() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(endPoint, accessKey, secretKey);
    }
}
