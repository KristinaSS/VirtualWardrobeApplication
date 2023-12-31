package com.vitualwardrobe.accounts.mapper;

import com.vitualwardrobe.accounts.models.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.UserDTO;

@Mapper
public interface AccountMapper {
    AccountMapper ACCOUNT_MAPPER = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "active", target = "isActive")
    UserDTO mapToDTO(Account account);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "isActive", target = "active")
    Account mapToModel(UserDTO userDTO);
}
