package org.example.service;

import org.example.ApplicationBootstrap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest(classes = ApplicationBootstrap.class)
public class FileServiceTest {

    @Autowired
    private FileService fileService;
    @Test
    public void uploadFileTest() {
        File file = new File("/Users/xiaoqi/Desktop/Screenshot2023-08-05.png");
        fileService.uploadFile(file);
    }
}
