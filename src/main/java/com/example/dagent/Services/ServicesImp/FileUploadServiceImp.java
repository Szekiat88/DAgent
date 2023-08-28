package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.FileUpload;
import com.example.dagent.Handler.ResourceNotFoundException;
import com.example.dagent.Repositories.FileUploadRepository;
import com.example.dagent.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServiceImp implements FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
    public FileUpload uploadFile(MultipartFile multipartFile) throws IOException {
        FileUpload uploadedFile = new FileUpload();
        uploadedFile.setFileName(multipartFile.getOriginalFilename());
        uploadedFile.setContentType(multipartFile.getContentType());
        uploadedFile.setFileData(multipartFile.getBytes());

        fileUploadRepository.save(uploadedFile);
        return uploadedFile;
    }

    @Override
    public byte[] getFileDataById(Long id) {
        FileUpload uploadedFile = fileUploadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id: " + id));
        return uploadedFile.getFileData();
    }

    @Override
    public String getFileNameById(Long id) {
        FileUpload uploadedFile = fileUploadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id: " + id));
        return uploadedFile.getFileName();
    }
}
