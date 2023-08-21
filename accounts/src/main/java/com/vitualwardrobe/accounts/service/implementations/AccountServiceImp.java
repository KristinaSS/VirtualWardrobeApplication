package com.vitualwardrobe.accounts.service.implementations;

import com.vitualwardrobe.accounts.exceptions.UserNotFoundException;
import com.vitualwardrobe.accounts.models.Account;
import com.vitualwardrobe.accounts.repository.AccountRepository;
import com.vitualwardrobe.accounts.service.AccountService;
import org.openapitools.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static com.vitualwardrobe.accounts.mapper.AccountMapper.ACCOUNT_MAPPER;

public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return accountRepository.findAll().stream()
                .map(ACCOUNT_MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserByID(String userId) {
        return ACCOUNT_MAPPER.mapToDTO(accountRepository.findById(Integer
                        .getInteger(userId))
                        .orElseThrow(() -> new UserNotFoundException(String.format("No user found with id: %s", userId))
                        ));
    }

    @Override
    public UserDTO getUserByEmail(String userEmail) {
        UserDTO user = ACCOUNT_MAPPER.mapToDTO(accountRepository.findAccountByEmail(userEmail));
        if(user == null){
            throw new UserNotFoundException(String.format("No user found with email: %s", userEmail));
        }
        return user;
    }

    @Override
    public String getUserRightsById(String userId) {
        return this.getUserByID(userId).getAccountType().getValue();
    }

    @Override
    public void updateUser(UserDTO updatedUser) {
        Account account = ACCOUNT_MAPPER.mapToModel(updatedUser);

        accountRepository.findById(updatedUser
                .getId())
                .orElseThrow(() -> new UserNotFoundException(String.format("No user found with id: %s", updatedUser.getId())));

        accountRepository.save(account);
    }
}
