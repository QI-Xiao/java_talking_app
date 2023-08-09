package org.example.service;

import org.example.ApplicationBootstrap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationBootstrap.class)
public class FileServiceTest {

    @Autowired
    private FileService fileService;
    @Test
    public void uploadFileTest() {
        fileService.uploadFile();
    }
}
