package org.example.DTO;

import javax.persistence.ElementCollection;
import java.util.Map;

public class ProductDTO {

    private Long id;
    private String productId;
    private String productName;
    private int price;
    private int inStock;
    private String desc;
    private String type;
    private Map<String, String> attr;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String productId, String productName, int price, int inStock, String desc, String type, Map<String, String> attr) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.inStock = inStock;
        this.desc = desc;
        this.type = type;
        this.attr = attr;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getAttr() {
        return attr;
    }

    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }
}
