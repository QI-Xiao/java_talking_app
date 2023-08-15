package org.example.controller;

import org.example.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = {"/files"})
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FileService fileService;

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String updateFile(@RequestParam("file") MultipartFile file, @RequestParam(value = "bucketName") String bucketName) {
//        logger.info("file {} - {}", file.getName(), file.getOriginalFilename());
        try {
            return fileService.uploadFile(bucketName, file);
        } catch (IOException e) {
            logger.error("unable to upload file {}", e.getMessage());
        }
        return null;
    }
}
