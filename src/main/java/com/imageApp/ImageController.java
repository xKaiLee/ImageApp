package com.imageApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {

    private final Map<String, BufferedImage> imageMap = new HashMap<>();

    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "Hello !";
    }
    @PostMapping(path = "/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            String id = generateUniqueId();
            imageMap.put(id, image);
            return ResponseEntity.ok(id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Błąd podczas przetwarzania obrazu.");
        }
    }
    private String generateUniqueId() {
        return java.util.UUID.randomUUID().toString();
    }
}
