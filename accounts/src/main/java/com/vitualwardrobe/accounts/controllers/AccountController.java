package com.vitualwardrobe.accounts.controllers;

import com.vitualwardrobe.accounts.service.AccountService;
import org.openapitools.api.AccountApi;
import org.openapitools.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountController implements AccountApi {
    @Autowired
    private AccountService accountService;

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO newUser) {
        return ResponseEntity.ok(accountService.createUser(newUser));
    }

    @Override
    public ResponseEntity<Void> deleteUser(BigDecimal userId) {
        accountService.deleteUser(userId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(accountService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> getUserByEmail(String userEmail) {
        return ResponseEntity.ok(accountService.getUserByEmail(userEmail));
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(BigDecimal userId) {
        return ResponseEntity.ok(accountService.getUserByID(userId));
    }

    @Override
    public ResponseEntity<String> getUserRightsById(BigDecimal userId) {
        return ResponseEntity.ok(accountService.getUserRightsById(userId));
    }

    @Override
    public ResponseEntity<Void> updateUser(UserDTO updatedUser) {
        accountService.updateUser(updatedUser);
        return ResponseEntity.ok(null);

    }
}
