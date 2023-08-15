//package org.example.service;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import org.example.ApplicationBootstrap;
//import org.example.util.FilenameUtil;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest(classes = ApplicationBootstrap.class)
//public class FileServiceTest {
//
//    @Autowired
//    private FileService fileService;
//
//    @Autowired
//    private AmazonS3 s3Client;
//
//    @Mock
//    private File file;
//
//    @Test
//    public void uploadFileTest_happyPath() throws IOException {
//        MultipartFile file = any(MultipartFile.class);
//        String bucketName = any(String.class);
//        when(file.getOriginalFilename()).thenReturn(any(String.class));
//        when(file.getContentType()).thenReturn(any(String.class));
//        when(file.getSize()).thenReturn(any(Long.class));
//        when(FilenameUtil.removeExtension(any(String.class))).thenReturn(any(String.class));
//
//
//        fileService.uploadFile(bucketName, file);
//        verify(s3Client, times(1)).putObject(any(PutObjectRequest.class));
//    }
//
//    @Test
//    public void uploadFileTest_fileIsNull() {
//
//    }
//}
