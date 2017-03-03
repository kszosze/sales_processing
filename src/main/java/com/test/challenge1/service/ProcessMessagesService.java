/**
 *  Processing Message Service
 *
 *  Service for process messages received. Information is stored and processed in memory.
 *
 */
package com.test.challenge1.service;

import com.test.challenge1.model.Message;
import com.test.challenge1.model.MessageType1;
import com.test.challenge1.model.MessageType2;
import com.test.challenge1.model.MessageType3;
import com.test.challenge1.util.MessageParser;
import com.test.io.TextDevice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessMessagesService {

    private final TextDevice ioDevice;

    private final TextDevice ouDevice;

    private final SalesManagerService salesManagerService;

    private final List<Message> messageQueue = new ArrayList<>();

    /**
     * Conctruct a Process Management Service
     * @param ioDevice Input Device
     * @param ouDevice Output Device
     * @param salesManagerService Sales Manager Service
     */
    public ProcessMessagesService(final TextDevice ioDevice, final TextDevice ouDevice, final SalesManagerService salesManagerService) {
        this.ioDevice = ioDevice;
        this.ouDevice = ouDevice;
        this.salesManagerService = salesManagerService;
    }

    /**
     * Get a message from the Input Device
     * @return the read message
     */
    public Message getMessage() {
        final Message message = MessageParser.getMessage(ioDevice.readLine());
        if (message instanceof MessageType3){
            messageQueue.add(message);
        }
        return message;
    }

    /**
     * Process a message following the Bussiness Rules
     * @param message received in the system
     * @return the result of the operation.
     */
    public boolean processMessage(Message message) {
        Boolean result = Boolean.TRUE;
        if (message instanceof MessageType1)
            salesManagerService.storeSale(new MessageType2(message.getProduct(), message.getPrice(), 1));
        else if (message instanceof MessageType2)
            salesManagerService.storeSale((MessageType2) message);
        else if (message instanceof MessageType3) {
            salesManagerService.applyOperation((MessageType3) message);
        } else {
            System.err.println("Wrong message received, exiting - " + message);
            result = Boolean.FALSE;
        }
        return result;
    }

    /**
     * Send the report Message to the Output Device
     *
     * @throws IOException if the output device fails
     */
    public void getMessageReport() throws IOException {
        final StringBuilder strBuilder = new StringBuilder();
        messageQueue.stream()
                .map(MessageType3.class::cast)
                .forEach(message ->
                        strBuilder.append(message.getOperation() + " " + message.getPrice() + "for product " + message.getProduct()));
        ouDevice.writer().write(strBuilder.toString());
    }

}
