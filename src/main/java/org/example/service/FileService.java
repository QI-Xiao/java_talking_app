package org.example.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    private String clientRegion = "us-east-1";
    String bucketName = "talkingapp";
    String stringObjKeyName = "sample.txt";

    public void uploadFile() {
        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(clientRegion)
                    .build();
            s3Client.putObject(bucketName, stringObjKeyName, "tttttt");
        }catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }

}
