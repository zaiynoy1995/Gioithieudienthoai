package com.zaj.gioithieudienthoai;

import com.google.gson.annotations.SerializedName;

public class Phone {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("images")
    private String images;
    @SerializedName("des")
    private String description;
    @SerializedName("price")
    private int price;

    public Phone(int id, String name, String images, String description, int price) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
