package org.spring.rest.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public Boolean uploadFile(MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            String UPLOAD_DIR = "C:/Users/shriy/Documents/Programming_Stuff/Spring/REST/src/main/resources/static/images/";
            java.nio.file.Path path = java.nio.file.Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            java.nio.file.Files.write(path, data);
            System.out.println("File uploaded successfully: " + path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
