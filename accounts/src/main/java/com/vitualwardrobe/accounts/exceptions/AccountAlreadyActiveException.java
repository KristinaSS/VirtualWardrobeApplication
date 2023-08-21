package com.vitualwardrobe.accounts.exceptions;

public class AccountAlreadyActiveException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "User account with this id: %d is already deactivated";
    public AccountAlreadyActiveException(int id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
