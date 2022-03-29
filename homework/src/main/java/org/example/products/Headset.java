package org.example.products;

import org.example.entity.Product;

public class Headset extends Product {

    private double batteryLife;
    private String typeOf;
    private boolean isWireless;

    public Headset(Long id, String productId, String productName, int price, int inStock, String text, String attribute1, String attribute2, String attribute3) {
        super(id, productId, productName, price, inStock, text, attribute1, attribute2, attribute3);
        attribute1 = this.typeOf;
        attribute2 = String.valueOf(this.batteryLife);
        attribute3 = String.valueOf(this.isWireless);
    }
}
