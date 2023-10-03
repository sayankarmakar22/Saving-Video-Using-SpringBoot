package com.sayan.VideoSaved.Services;

import com.sayan.VideoSaved.Model.Video;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

public interface VideoService {
    String saveVideo(MultipartFile file) throws IOException;

    Resource getVideo(String fileName) throws FileNotFoundException, MalformedURLException;
}
