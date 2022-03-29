package org.example.products;

import org.example.entity.Product;

public class Tv extends Product {

    private String resolution;
    private String storage;
    private String version;

    public Tv(Long id, String productId, String productName, int price, int inStock, String text, String attribute1, String attribute2, String attribute3) {
        super(id, productId, productName, price, inStock, text, attribute1, attribute2, attribute3);
        attribute1 = this.resolution;
        attribute2 = this.storage;
        attribute3 = this.version;
    }
}
