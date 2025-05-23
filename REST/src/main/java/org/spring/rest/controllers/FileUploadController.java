package org.spring.rest.controllers;

import org.spring.rest.helpers.FileUploadHelper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@RestController
public class FileUploadController {

    private final FileUploadHelper fileUploadHelper;

    public FileUploadController(FileUploadHelper fileUploadHelper) {
        this.fileUploadHelper = fileUploadHelper;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty.");
        } else if (!Objects.equals(file.getContentType(), "image/jpeg")) {
            return ResponseEntity.badRequest().body("File type is not supported.");
        }

        Boolean isUploaded = fileUploadHelper.uploadFile(file);

        if (!isUploaded) {
            return ResponseEntity.status(500).body("File upload failed.");
        }

        return ResponseEntity.ok("File uploaded successfully: " + file.getOriginalFilename());
    }
}
