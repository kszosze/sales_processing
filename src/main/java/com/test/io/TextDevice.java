package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public abstract class TextDevice {
    public abstract TextDevice printf(String fmt, Object... params)
            throws DeviceException;

    public abstract String readLine() throws DeviceException;

    public abstract BufferedReader reader() throws DeviceException;

    public abstract BufferedWriter writer() throws DeviceException;
}