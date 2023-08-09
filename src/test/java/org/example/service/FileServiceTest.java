package org.example.service;

import org.example.ApplicationBootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootstrap.class)
public class FileServiceTest {

    @Autowired
    private FileService fileService;
    @Test
    public void uploadFileTest() {
        fileService.uploadFile();
    }
}
