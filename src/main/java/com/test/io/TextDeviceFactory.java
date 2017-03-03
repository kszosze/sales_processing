package com.test.io;

import java.io.*;

public final class TextDeviceFactory {

    private final static String DEFAULT_REPORT_FILE_NAME = "reports.txt";

    private TextDeviceFactory() {}

    private static TextDevice DEFAULT = (System.console() == null) ? streamDevice(
            System.in, System.out)
            : new ConsoleDevice(System.console());

    private static TextDevice DEFAULT_REPORT = new FileDevice(DEFAULT_REPORT_FILE_NAME);

    /**
     * The default system text I/O device.
     *
     * @return the default device
     */
    public static TextDevice defaultTextDevice() {
        return DEFAULT;
    }

    /**
     * The default device for Reports
     *
     * @return the default report device
     */
    public static TextDevice defaultReportDevice() {
        return DEFAULT_REPORT;
    }

    /**
     * Returns a text I/O device wrapping the given streams. The default system
     * encoding is used to decode/encode data.
     *
     * @param in
     *          an input source
     * @param out
     *          an output target
     * @return a new device
     */
    public static TextDevice streamDevice(InputStream in, OutputStream out) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        PrintWriter writer = new PrintWriter(out, true);
        return new CharacterDevice(reader, writer);
    }

    /**
     * Returns a text I/O device wrapping the given streams.
     *
     * @param reader
     *          an input source
     * @param writer
     *          an output target
     * @return a new device
     */
    public static TextDevice characterDevice(BufferedReader reader,
                                             PrintWriter writer) {
        return new CharacterDevice(reader, writer);
    }
}
