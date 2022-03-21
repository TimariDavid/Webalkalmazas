package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Product {

    @Id
    private Long id;
    private String productId;
    private String productName;
    private int price;
    private int inStock;
    private String text;

    private String attribute1;
    private String attribute2;
    private String attribute3;

    public Product(Long id, String productId, String productName, int price, int inStock, String text, String attribute1, String attribute2, String attribute3) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.inStock = inStock;
        this.text = text;
        this.attribute1 = attribute1;
        this.attribute2 = attribute2;
        this.attribute3 = attribute3;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }
}
