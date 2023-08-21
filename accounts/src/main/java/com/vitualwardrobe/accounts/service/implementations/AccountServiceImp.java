package com.vitualwardrobe.accounts.service.implementations;

import com.vitualwardrobe.accounts.exceptions.AccountAlreadyActiveException;
import com.vitualwardrobe.accounts.exceptions.EmailUnavailableException;
import com.vitualwardrobe.accounts.exceptions.UserNotFoundException;
import com.vitualwardrobe.accounts.models.Account;
import com.vitualwardrobe.accounts.repository.AccountRepository;
import com.vitualwardrobe.accounts.service.AccountService;
import org.openapitools.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.vitualwardrobe.accounts.mapper.AccountMapper.ACCOUNT_MAPPER;

@Service
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
    public UserDTO getUserByID(BigDecimal userId) {
        return ACCOUNT_MAPPER.mapToDTO(accountRepository.findById(userId.intValue())
                        .orElseThrow(() -> new UserNotFoundException("id", ""+userId.intValue()))
                        );
    }

    @Override
    public UserDTO getUserByEmail(String userEmail) {
        UserDTO user = ACCOUNT_MAPPER.mapToDTO(accountRepository.findAccountByEmail(userEmail));
        if(user == null){
            throw new UserNotFoundException("email", userEmail);
        }
        return user;
    }

    @Override
    public String getUserRightsById(BigDecimal userId) {
        return this.getUserByID(userId).getAccountType().getValue();
    }

    @Override
    public void updateUser(UserDTO updatedUser) {
        Account account = ACCOUNT_MAPPER.mapToModel(updatedUser);

        //check if account exists
        String oldEmail = accountRepository.findById(updatedUser
                .getId())
                .orElseThrow(() -> new UserNotFoundException("id", ""+updatedUser.getId())).getEmail();
        String newEmail = updatedUser.getEmail();

        //check if email available
        if(!oldEmail.equals(newEmail) && validateNewEmail(newEmail)){
            throw new EmailUnavailableException(newEmail);
        }

        accountRepository.save(account);
    }

    @Override
    public void createUser(UserDTO createdUser) {
        if(validateNewEmail(createdUser.getEmail())){
            throw new EmailUnavailableException(createdUser.getEmail());
        }
        Account account = ACCOUNT_MAPPER.mapToModel(createdUser);
        accountRepository.save(account);
    }

    @Override
    public void deleteUser(BigDecimal userId) {
        //check if account exists
        Account account = accountRepository.findById(userId.intValue())
                .orElseThrow(() -> new UserNotFoundException("id", ""+userId.intValue()));

        //validate account already not active
        if(account.isActive()){
            account.setActive(false);
            accountRepository.save(account);
        }else {
            throw new AccountAlreadyActiveException(userId.intValue());
        }
    }

    private boolean validateNewEmail(String newEmail) {
        return accountRepository.findAccountByEmail(newEmail) == null;
    }


}
