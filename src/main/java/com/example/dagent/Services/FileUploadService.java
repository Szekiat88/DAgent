package com.example.dagent.Services;

import com.example.dagent.Entities.FileUpload;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileUploadService {
    FileUpload uploadFile(MultipartFile multipartFile) throws IOException;
    byte[] getFileDataById(Long id);
    public String getFileNameById(Long id);

    public List<byte[]> findAllFilesData() ;

    List<FileUpload> findAllUploadedFile() ;

    Page<FileUpload> getRequestFiltersUploadedFile(int page, int limit);


    }
