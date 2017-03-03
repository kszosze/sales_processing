package com.test.io;

import java.io.*;

class CharacterDevice extends TextDevice {
    private final BufferedReader reader;
    private final PrintWriter writer;

    public CharacterDevice(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public CharacterDevice printf(String fmt, Object... params)
            throws DeviceException {
        writer.printf(fmt, params);
        return this;
    }

    @Override
    public String readLine() throws DeviceException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public BufferedReader reader() throws DeviceException {
        return reader;
    }

    @Override
    public BufferedWriter writer() throws DeviceException {
        return new BufferedWriter(writer);
    }
}
