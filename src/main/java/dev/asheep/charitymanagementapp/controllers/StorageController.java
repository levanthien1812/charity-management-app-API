package dev.asheep.charitymanagementapp.controllers;

import dev.asheep.charitymanagementapp.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping
    public String create(@RequestParam(name = "image") MultipartFile file) {
        try {
            String fileName = storageService.saveFile(file);
            return storageService.getImageUrl(fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
