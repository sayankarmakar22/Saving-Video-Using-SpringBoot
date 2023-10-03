package com.sayan.VideoSaved.Repository;

import com.sayan.VideoSaved.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepo extends JpaRepository<Video, Integer> {
    Video findById(int id);
}
