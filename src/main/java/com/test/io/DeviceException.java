package com.test.io;


public class DeviceException  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DeviceException(Throwable t) {
        super(t);
    }
}