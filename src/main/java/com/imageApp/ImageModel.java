package com.imageApp;

import java.awt.image.BufferedImage;

public class ImageModel {
    private String id;
    private BufferedImage image;

    public ImageModel(String id, BufferedImage image) {
        this.id = id;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
