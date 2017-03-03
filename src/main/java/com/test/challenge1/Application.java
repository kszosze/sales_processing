package com.test.challenge1;

import com.test.challenge1.service.ProcessMessagesService;
import com.test.challenge1.service.SalesManagerService;
import com.test.io.TextDevice;
import com.test.io.TextDeviceFactory;

public class Application {

    public static void  main(String[] args) {

        final TextDevice ioDevice = TextDeviceFactory.defaultTextDevice();

        ioDevice.printf("Processing Message systems starting....");
        ioDevice.printf("Introduce the messages");
        final SalesManagerService salesManagerService = new SalesManagerService(ioDevice);
        final ProcessMessagesService pMS = new ProcessMessagesService(ioDevice, ioDevice, salesManagerService);

        int count=0;
        while (pMS.processMessage(pMS.getMessage())) {
            count++;
            if (count == 10) {
                try {
                    ioDevice.printf("Printing Report");
                    salesManagerService.getReport();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (count == 50) {
                try {
                    ioDevice.printf("Pausing for 20 sec. No Messages will be received");
                    Thread.sleep(20000);
                    pMS.getMessageReport();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
