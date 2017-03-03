package com.test.challenge1.model;

import com.test.challenge1.model.enums.OperationTypeEnum;

/**
 * Created by kszosze on 02/03/2017.
 */
public class MessageType3 extends Message {

    private final OperationTypeEnum operation;

    public MessageType3(String product, Integer price, OperationTypeEnum operation) {
        super(product, price);
        this.operation = operation;
    }

    public OperationTypeEnum getOperation() {
        return operation;
    }
}
