package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: ls
 * @description:
 * @create: 2020-01-07 23:42
 */
@Service
@Slf4j
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties prop;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);

    //private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    public String upload(MultipartFile file) {
        try {
            // 1.图片信息校验
            //1.1.校验文件类型
            String type = file.getContentType();
            if (!prop.getAllowTypes().contains(type)) {
                 logger.info("上传失败，文件类型不匹配：{}", type);
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            // 1.2.校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }

            // 2、保存图片
            // 2.1、生成保存目录
           /* File dir = new File("D:\\heima\\upload");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // 2.2、保存图片
            file.transferTo(new File(dir, file.getOriginalFilename()));
            // 2.3、拼接图片地址
            String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();*/
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);
            System.out.println(storePath.getFullPath());
            return prop.getBaseUrl() + storePath.getFullPath();

        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }

    }
}
