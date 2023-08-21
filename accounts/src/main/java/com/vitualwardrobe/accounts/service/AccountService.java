package com.vitualwardrobe.accounts.service;

import org.openapitools.model.UserDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface AccountService {
    List<UserDTO> getAllUsers();

    UserDTO getUserByID(BigDecimal userId);

    UserDTO getUserByEmail(String userEmail);

    String getUserRightsById(BigDecimal userId);

    void updateUser(UserDTO updatedUser);

    UserDTO createUser (UserDTO updatedUser);

    void deleteUser (BigDecimal user);
}
