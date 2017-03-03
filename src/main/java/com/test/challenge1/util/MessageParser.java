/**
 * Parse messages and build the required objects
 */
package com.test.challenge1.util;


import com.test.challenge1.model.Message;
import com.test.challenge1.model.MessageType1;
import com.test.challenge1.model.MessageType2;
import com.test.challenge1.model.MessageType3;
import com.test.challenge1.model.enums.OperationTypeEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MessageParser {

    private final static Pattern messageType1 = Pattern.compile("^([A-Z]*)\\sAT\\s([0-9]+)P");
    private final static Pattern messageType2 = Pattern.compile("^([0-9]*)\\sSALES\\sOF\\s([A-Z]*)\\sAT\\s([0-9]+)P");
    private final static Pattern messageType3 = Pattern.compile("^(ADD|SUBSTRACT|MULTIPLY)\\s([0-9]+)P\\s([A-Z]*)");

    /**
     * Check if the message if of Type 1
     * @param message to validate
     * @return TRUE in case the message correspond to the Type 1
     */
    public static boolean isType1(final String message) {
        return messageType1.matcher(message.toUpperCase()).matches();
    }

    /**
     * Check if the message if of Type 2
     * @param message to validate
     * @return TRUE in case the message correspond to the Type 2
     */
    public static boolean isType2(final String message) {
        return messageType2.matcher(message.toUpperCase()).matches();
    }

    /**
     * Check if the message if of Type 2
     * @param message to validate
     * @return TRUE in case the message correspond to the Type 2
     */
    public static boolean isType3(final String message) {
        return messageType3.matcher(message.toUpperCase()).matches();
    }

    /**
     * Convert a message in a Type 1 Message object
     * @param message to convert into an Object
     * @return the Message Type Object
     */
    public static MessageType1 getMessageType1(final String message) {
        MessageType1 msgType1 = null;
        final Matcher matcher = messageType1.matcher(message.toUpperCase());
        if (matcher.find()) {
            msgType1 = new MessageType1(matcher.group(1), Integer.parseInt(matcher.group(2)));
        }
        return msgType1;
    }

    /**
     * Convert a message in a Type 2 Message object
     * @param message to convert into an Object
     * @return the Message Type Object
     */
    public static MessageType2 getMessageType2(final String message) {
        MessageType2 msgType2 = null;
        final Matcher matcher = messageType2.matcher(message.toUpperCase());
        if (matcher.find()) {
            msgType2 = new MessageType2(matcher.group(2), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(1)));
        }
        return msgType2;
    }

    /**
     * Convert a message in a Type 3 Message object
     * @param message to convert into an Object
     * @return the Message Type Object
     */
    public static MessageType3 getMessageType3(final String message) {
        MessageType3 msgType3 = null;
        final Matcher matcher = messageType3.matcher(message.toUpperCase());
        if (matcher.find()) {
            msgType3 = new MessageType3(matcher.group(3), Integer.parseInt(matcher.group(2)), OperationTypeEnum.valueOf(matcher.group(1)));
        }
        return msgType3;
    }

    /**
     * Retunn a Message Object from a String
     * @param message to convert
     * @return a Message Object
     */
    public static Message getMessage(final String message) {
        Message messageType = null;
        if (isType1(message)) {
            messageType = getMessageType1(message);
        } else if (isType2(message)) {
            messageType = getMessageType2(message);
        } else if (isType3(message)) {
            messageType = getMessageType3(message);
        }

        return messageType;
    }
}
