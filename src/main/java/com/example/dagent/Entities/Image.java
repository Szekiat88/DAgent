package com.example.dagent.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contentType;
    @Lob
    @Column(length = 1048576) // Adjust the length as needed
    private byte[] image;

    public void setData(byte[] bytes) {
    }

    @Entity
    public static class FileUpload {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String originalFileName;
        private String contentType;
        @Lob
        @Column(name = "file_data")
        private byte[] fileData;// You can store the file path or any identifier here

        // Constructors, getters, setters
    }
}
