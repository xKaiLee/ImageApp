package com.imageApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ImageController {

    private Map<Long, ImageModel> imageMap = new HashMap<>();
    private long idCounter = 0;

    @RequestMapping(path = "/hello")
    public String sayHello() {
        return "Hello !";
    }
    @PostMapping("/image")
    public ResponseEntity<Long> uploadImage(@RequestBody byte[] imageData) {
        try {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
            long id = generateUniqueId();
            imageMap.put(id, new ImageModel(String.valueOf(id), bufferedImage));
            return ResponseEntity.ok(id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(-1L);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        if (imageMap.containsKey(id)) {
            imageMap.remove(id);
            System.out.println("Usunales obraz");
            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("image/{id}/size")
    public ResponseEntity<Map<String, Integer>> getImageSize(@PathVariable Long id) {
        if (imageMap.containsKey(id)) {
            BufferedImage image = imageMap.get(id).getImage();
            Map<String, Integer> size = new HashMap<>();
            size.put("width", image.getWidth());
            size.put("height", image.getHeight());
            return ResponseEntity.ok(size);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}/histogram")
    public ResponseEntity<Map<String, Object>> getImageHistogram(@PathVariable String id) {

        if (imageMap.containsKey(id)) {
            Map<String, Object> histogramData = new HashMap<>();
            histogramData.put("placeholder", "data");
            return ResponseEntity.ok(histogramData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}/crop")
    public ResponseEntity<byte[]> cropImage(
            @PathVariable String id,
            @RequestParam int start,
            @RequestParam int stop,
            @RequestParam int width,
            @RequestParam int height) {
        if (imageMap.containsKey(id)) {
            BufferedImage originalImage = imageMap.get(id).getImage();

            byte[] croppedImageData = new byte[0];
            return ResponseEntity.ok(croppedImageData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    private synchronized long generateUniqueId() {
        long id = idCounter++;
        System.out.println("Generated ID: " + id);
        return id;
    }
}
