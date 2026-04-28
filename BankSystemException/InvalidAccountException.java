package com.wipro.JavaBasics.BankSystemException;

class InvalidAmountException extends Exception {
    InvalidAmountException(String msg) {
        super(msg);
    }
}