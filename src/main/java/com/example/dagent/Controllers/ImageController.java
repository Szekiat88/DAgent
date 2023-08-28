package com.example.dagent.Controllers;

import com.example.dagent.Entities.Image;
import com.example.dagent.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam String name, @RequestParam MultipartFile file) {
        try {
            Image image = new Image();
            image.setName(name);
            image.setContentType(file.getContentType());
            image.setData(file.getBytes());
            imageRepository.save(image);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }

//    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
//    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
//        // Retrieve image data from the database based on the provided ID
//        byte[] imageData = retrieveImageDataFromDatabase(id);
//
//        if (imageData != null) {
//            // Convert image data to BufferedImage
//            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
//
//            if (bufferedImage != null) {
//                // Convert BufferedImage to JPEG format
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ImageIO.write(bufferedImage, "jpg", baos);
//
//                // Get the JPEG image data as a byte array
//                byte[] jpegImageData = baos.toByteArray();
//
//                // Set appropriate response headers
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.IMAGE_JPEG);
//
//                return new ResponseEntity<>(jpegImageData, headers, HttpStatus.OK);
//            }
//        }
//
//        // Return an error response if image data is not available
//        return ResponseEntity.notFound().build();
//    }
//
//    private byte[] retrieveImageDataFromDatabase(Long id) {
//        Optional<Image> imageOptional = imageRepository.findById(id);
//        System.out.println("heeloo"+imageOptional);
//        if (imageOptional.isPresent()) {
//            Image image = imageOptional.get();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.parseMediaType(image.getContentType()));
//            return image.getData();
//        }
//        return null; // Return null if image data is not found
//    }

    @GetMapping(value = "/hello/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            HttpHeaders headers = new HttpHeaders();

            // Convert the image data to BufferedImage
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image.getImage()));

            if (bufferedImage != null) {
                // Convert BufferedImage to JPEG format
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", baos);

                // Get the JPEG image data as a byte array
                byte[] jpegImageData = baos.toByteArray();

                headers.setContentType(MediaType.IMAGE_JPEG);

                return new ResponseEntity<>(jpegImageData, headers, HttpStatus.OK);
            }
        }

        return ResponseEntity.notFound().build();
    }



    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage2(@PathVariable Long id) {
        Optional<Image> imageOptional = imageRepository.findById(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType(image.getContentType()));
            return new ResponseEntity<>(image.getImage(), headers, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}