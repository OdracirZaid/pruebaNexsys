package com.pruebaTecnica.ricardoDiaz.entity;

import java.util.Date;
import java.util.List;

public class ProductEntity {

    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private List<String> images;
    private Date creationAt;
    private Date updatedAt;
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "pid=" + id +
                ", name='" + title + '\'' +
                ", priceFinal=" + price +
                ", description='" + description + '\'' +
                '}';
    }
    public String toStringId() {
        return "ProductEntity{" +
                "pid=" + id + '\'' +
                '}';
    }

}
