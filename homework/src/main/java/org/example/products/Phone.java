package org.example.products;

import org.example.entity.Product;

public class Phone extends Product {

    private double screenSize;
    private double batteryLife;


    public Phone(Long id, String productId, String productName, int price, int inStock, String text, String attribute1, String attribute2, String attribute3) {
        super(id, productId, productName, price, inStock, text, attribute1, attribute2, attribute3);
        attribute1 = String.valueOf(this.screenSize);
        attribute2 = String.valueOf(this.batteryLife);
        attribute3 = null;
    }
}
