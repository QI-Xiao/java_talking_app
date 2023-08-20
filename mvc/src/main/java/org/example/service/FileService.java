package org.example.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.example.util.FilenameUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AmazonS3 s3Client;

    public String uploadFile(String bucketName, MultipartFile file) throws IOException {
        if (file==null) {
            logger.error("no file");
            return null;
        }

        String uuid = UUID.randomUUID().toString();
        String originalFileName = file.getOriginalFilename();

        String newFileName = FilenameUtil.removeExtension(originalFileName) + uuid + "." + FilenameUtil.getExtension(originalFileName);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());
//        metadata.addUserMetadata("title", "someTitle");

        try {
            PutObjectRequest request = new PutObjectRequest(bucketName, newFileName, file.getInputStream(), metadata);
            s3Client.putObject(request);
            return getUrl(bucketName, newFileName);
        }
        catch (SdkClientException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String getUrl(String bucketName, String s3Key) {
        return s3Client.getUrl(bucketName, s3Key).toString();
    }
}
