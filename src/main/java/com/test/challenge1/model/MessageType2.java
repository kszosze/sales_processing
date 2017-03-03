package com.test.challenge1.model;

/**
 * Created by kszosze on 02/03/2017.
 */
public class MessageType2 extends Message {

    private final Integer quantity;

    public MessageType2(String product, Integer price, Integer quantity) {
        super(product, price);
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
