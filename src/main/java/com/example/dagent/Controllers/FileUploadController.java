package com.example.dagent.Controllers;
import com.example.dagent.Entities.FileUpload;
import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Handler.ResponseHandler;
import com.example.dagent.Services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/upload")
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
        System.out.println("Hello fileDate" + fileData);

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(fileData, headers, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<byte[]>> getAllFilesData() {

        List<byte[]> filesData = fileUploadService.findAllFilesData();
        for (byte[] byteArray : filesData) {
            System.out.println("hihi" + Arrays.toString(byteArray));
        }
        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(filesData, headers, HttpStatus.OK);
    }

    @GetMapping("/allUploadedFile")
    public ResponseEntity<Object> getAllUploadedFile() {

        Page<FileUpload> filesData = fileUploadService.getRequestFiltersUploadedFile(0,2);
        filesData.map(projectDetail -> projectDetail.getId());
        return ResponseHandler.handleResponse("Successfully get products", HttpStatus.OK,filesData);

    }



    /*@GetMapping("/all/all")
    public ResponseEntity<List<FileUpload>> getAllImages() {
        List<FileUpload> uploadedFiles = getAllImageBytes(); // Replace with your method to retrieve image files

        if (uploadedFiles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Set appropriate response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // You can use MediaType.APPLICATION_JSON or adjust it based on your response format

        return new ResponseEntity<>(uploadedFiles, headers, HttpStatus.OK);
    }

    private List<byte[]> findAllImageBytes() {
        List<byte[]> uploadedFiles = fileUploadService.findAllFilesData();
        return uploadedFiles; // Placeholder
    }*/


}

