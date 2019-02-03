package dev.psychocoders.sathchalein.models;

public class ImageModel {
    private String name;
    private int imgres;

    public ImageModel(String name, int imgres) {
        this.name = name;
        this.imgres = imgres;
    }

    public String getName() {
        return name;
    }

    public int getImgres() {
        return imgres;
    }
}
