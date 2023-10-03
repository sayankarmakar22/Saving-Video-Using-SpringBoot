package com.sayan.VideoSaved.Controllers;

import com.sayan.VideoSaved.Model.Video;
import com.sayan.VideoSaved.Services.Implementation.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.PublicKey;

@RestController
@RequestMapping("/video")
public class MainController {
    @Autowired
    private VideoServiceImpl videoService;

    @PostMapping("/save")
    public ResponseEntity<String> saveVideo(@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(videoService.saveVideo(file), HttpStatus.CREATED);
    }
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> getVideo(@PathVariable String fileName) throws MalformedURLException, FileNotFoundException {
        return new ResponseEntity<>(videoService.getVideo(fileName), HttpStatus.CREATED);
    }
}
