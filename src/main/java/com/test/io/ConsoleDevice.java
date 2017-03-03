package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;

class ConsoleDevice
        extends TextDevice {
    private final Console console;

    public ConsoleDevice(Console console) {
        this.console = console;
    }

    @Override
    public TextDevice printf(String fmt, Object... params)
            throws DeviceException {
        console.format(fmt, params);
        return this;
    }

    @Override
    public BufferedReader reader() throws DeviceException {
        return new BufferedReader(console.reader());
    }

    @Override
    public String readLine() throws DeviceException {
        return console.readLine();
    }


    @Override
    public BufferedWriter writer() throws DeviceException {
        return new BufferedWriter(console.writer());
    }
}

