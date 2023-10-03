package com.sayan.VideoSaved.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "video")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Lob
    private byte[] content;
}
