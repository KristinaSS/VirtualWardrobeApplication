package com.vitualwardrobe.accounts.controllers;

import org.openapitools.api.AccountApi;
import org.openapitools.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController implements AccountApi {
    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(String userId) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<String> getUserRightsById(String userId) {
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<UserDTO> getUserByEmail(String userEmail) {
        return ResponseEntity.ok(null);
    }
    @Override
    public ResponseEntity<Void> updateUser(UserDTO updatedUser) {
        return ResponseEntity.ok(null);

    }
}
