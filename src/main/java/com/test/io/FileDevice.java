package com.test.io;


import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Formatter;
import java.util.Locale;

public class FileDevice extends TextDevice {

    private final File file;

    private BufferedReader fileReader;

    private BufferedWriter fileWriter ;

    private final Formatter formatter = new Formatter(new StringBuilder(), Locale.UK);

    public FileDevice(final File file) {
        this.file = file;
    }

    public FileDevice(final String fileName) {
        this.file = new File(fileName);
    }

    @PostConstruct
    public void init() throws FileNotFoundException, IOException {
        this.fileReader = new BufferedReader(new FileReader(file));
        this.fileWriter = new BufferedWriter(new FileWriter(file));
    }
    @Override
    public TextDevice printf(final String fmt, Object... params) throws DeviceException {

        try {
            fileWriter.write(formatter.format(fmt, params).toString());
        } catch (IOException e) {
            throw new DeviceException(e);
        }
        return this;
    }

    @Override
    public String readLine() throws DeviceException {
        try {
            return fileReader.readLine();
        } catch (IOException e) {
            throw new DeviceException(e);
        }
    }

    @Override
    public BufferedReader reader() throws DeviceException {
        return new BufferedReader(fileReader);
    }

    @Override
    public BufferedWriter writer() throws DeviceException {
        return new BufferedWriter(fileWriter);
    }
}
