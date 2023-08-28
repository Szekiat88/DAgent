package com.example.dagent.Controllers;
import com.example.dagent.Entities.FileUpload;
import com.example.dagent.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        FileUpload uploadedFile = fileUploadService.uploadFile(file);
        return ResponseEntity.ok("File uploaded successfully. ID: " + uploadedFile.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFileData(@PathVariable Long id) {
        byte[] fileData = fileUploadService.getFileDataById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // Retrieve the file name associated with the given ID from the database
        String fileName = fileUploadService.getFileNameById(id);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }

}

