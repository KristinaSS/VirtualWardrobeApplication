package com.vitualwardrobe.accounts.models;

import com.vitualwardrobe.accounts.constants.AccountType;
import jakarta.persistence.*;

@Entity(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "account_type")
    private AccountType accountType;
}