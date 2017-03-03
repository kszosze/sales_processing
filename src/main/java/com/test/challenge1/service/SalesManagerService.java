/**
 * Sales Manager Service
 *
 * Service to process and store the sales.
 */
package com.test.challenge1.service;

import com.test.challenge1.model.MessageType2;
import com.test.challenge1.model.MessageType3;
import com.test.challenge1.model.Sale;
import com.test.io.TextDevice;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;


public class SalesManagerService {

    private final TextDevice ouDevice;

    private final static Map<String, List<Sale>> messageStorage = new HashMap<>();

    public SalesManagerService(TextDevice ouDevice) {
        this.ouDevice = ouDevice;
    }

    /**
     * Store a received sale
     * @param message Message with the sale information
     */
    public void storeSale(final MessageType2 message) {
        if (!messageStorage.containsKey(message.getProduct())) {
            messageStorage.put(message.getProduct(), new ArrayList<>());
        }
        messageStorage.get(message.getProduct()).add(new Sale(message.getProduct(), message.getPrice(), message.getQuantity()));

    }

    /**
     * Applu the operation to all the sale related in the message
     * @param message containing the operation information
     */
    public void applyOperation(final MessageType3 message) {
        if (messageStorage.containsKey(message.getProduct())) {
            messageStorage.get(message.getProduct()).forEach(sale -> sale.executeOperation(message.getOperation(), message.getPrice()));
        }
    }

    /**
     * Send a report to the Output Device
     * @throws Exception in case the device fails
     */
    public void getReport() throws Exception {
        final StringBuilder strBuilder = new StringBuilder();
        messageStorage.keySet().forEach(product -> {
                final LongAdder amountAdder = new LongAdder();
                final LongAdder salesAdder = new LongAdder();

                messageStorage.get(product).forEach(sale -> {
                    amountAdder.add(sale.getPrice() * sale.getAmount());
                    salesAdder.add(sale.getAmount());
                });
                strBuilder.append("Total of " +salesAdder.intValue() + " sales of " + product + " for a total  " + amountAdder.toString());
            }
        );
        ouDevice.writer().write(strBuilder.toString());
    }
}
