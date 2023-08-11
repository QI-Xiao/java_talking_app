package org.example.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    String bucketName = "talkingapp";

    @Autowired
    AmazonS3 s3Client;

    public void uploadFile(File file) {
        if (file==null) {
            logger.error("no file");
            return;
        }
        try {
            s3Client.putObject(bucketName, file.getName(), file);
        }catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

}
