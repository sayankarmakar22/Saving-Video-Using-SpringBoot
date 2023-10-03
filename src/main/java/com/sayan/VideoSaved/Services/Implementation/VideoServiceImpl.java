package com.sayan.VideoSaved.Services.Implementation;

import com.sayan.VideoSaved.Model.Video;
import com.sayan.VideoSaved.Repository.VideoRepo;
import com.sayan.VideoSaved.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepo videoRepo;

    @Value("${upload.dir}")
    private String uploadDir;
    @Override
    public String saveVideo(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path filePath = Paths.get(uploadDir, fileName);

        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
            outputStream.write(file.getBytes());
        }
        return "Uploaded!!";

    }

    @Override
    public Resource getVideo(String fileName) throws FileNotFoundException, MalformedURLException {
        Path filePath = Paths.get(uploadDir).resolve(fileName);
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists() || resource.isReadable()) {
            return resource;
        } else {
            throw new FileNotFoundException("File not found: " + fileName);
        }
    }
}
