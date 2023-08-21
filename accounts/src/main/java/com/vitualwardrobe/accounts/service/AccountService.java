package com.vitualwardrobe.accounts.service;

import com.vitualwardrobe.accounts.exceptions.UserNotFoundException;
import org.openapitools.model.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<UserDTO> getAllUsers();

    UserDTO getUserByID(String userId) throws UserNotFoundException;

    UserDTO getUserByEmail(String userEmail);

    String getUserRightsById(String userId);

    void updateUser(UserDTO updatedUser);
}
