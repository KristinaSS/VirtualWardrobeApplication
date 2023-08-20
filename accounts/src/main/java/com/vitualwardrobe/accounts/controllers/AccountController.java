package com.vitualwardrobe.accounts.controllers;

import org.openapitools.api.AccountApi;
import org.openapitools.model.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AccountController implements AccountApi {
    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(String userId) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> getUserById_0(String userEmail) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateUser(UserDTO updatedUser) {
        return null;
    }
}
