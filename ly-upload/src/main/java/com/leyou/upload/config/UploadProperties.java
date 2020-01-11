package com.leyou.upload.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-10 1:22
 */
@ConfigurationProperties(prefix = "ly.upload")
@Data
public class UploadProperties {

    private String baseUrl;
    private List<String> allowTypes;

}
