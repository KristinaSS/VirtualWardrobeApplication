package com.vitualwardrobe.accounts.exceptions;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {

    private static final String MESSAGE_TEMPLATE = "No user found with %s: %s";

    public UserNotFoundException(String infoType, String info) {
        super(String.format(MESSAGE_TEMPLATE, infoType, info));
    }
}
