package com.dh.exception;

import java.util.NoSuchElementException;

public class ExceptionTest {
    public void throwTest () throws NumberFormatException,NoSuchElementException {
        throw new NullPointerException();
    }
}
