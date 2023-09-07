package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.FileUpload;
import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Handler.ResourceNotFoundException;
import com.example.dagent.Repositories.FileUploadRepository;
import com.example.dagent.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public String getFileNameById(Long id) {
        FileUpload uploadedFile = fileUploadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id: " + id));
        return uploadedFile.getFileName();
    }

    @Override
    public byte[] getFileDataById(Long id) {
        FileUpload uploadedFile = fileUploadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("File not found with id: " + id));
        System.out.println("This is uploadedFiles by id" + uploadedFile.getFileData());
        return uploadedFile.getFileData();
    }

    @Override
    public List<byte[]> findAllFilesData() {
        List<byte[]> listOfFileData = new ArrayList<>();;
        List<FileUpload> uploadedFiles = fileUploadRepository.findAll();
        uploadedFiles.forEach(fileUpload -> listOfFileData.add(fileUpload.getFileData()));

        return listOfFileData;
    }

    @Override
    public List<FileUpload> findAllUploadedFile() {
        return null;
    }

    public Page<FileUpload> findAllUploadedFile(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return fileUploadRepository.findAll(pageable);
    }

    @Override
    public Page<FileUpload> getRequestFiltersUploadedFile(int page, int limit) {
        Page<FileUpload> productPage = null;
        productPage = findAllUploadedFile(page, limit);

        return productPage;
    }


}
