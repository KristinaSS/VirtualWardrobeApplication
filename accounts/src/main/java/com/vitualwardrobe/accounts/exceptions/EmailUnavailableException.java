package com.vitualwardrobe.accounts.exceptions;

public class EmailUnavailableException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "User with this email: %s already exists";
    public EmailUnavailableException(String email) {
        super(String.format(MESSAGE_TEMPLATE, email));
    }
}
