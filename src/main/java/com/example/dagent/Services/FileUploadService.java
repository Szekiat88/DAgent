package com.example.dagent.Services;

import com.example.dagent.Entities.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {
    FileUpload uploadFile(MultipartFile multipartFile) throws IOException;
    byte[] getFileDataById(Long id);
    public String getFileNameById(Long id);



}
