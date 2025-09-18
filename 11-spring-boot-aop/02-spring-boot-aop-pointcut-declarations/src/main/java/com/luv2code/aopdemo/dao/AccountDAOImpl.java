package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceCode;

    @Override
    public String getName() {
        System.out.println("Doing a GET method");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("Doing a SET method");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println("Doing a GET method");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println("Doing a SET method");
        this.serviceCode = serviceCode;
    }

    @Override
    public void addAccount(Account theAccount) {
        System.out.println(getClass() + " : DOING MY DB WORK AT ACCOUNT");
    }

    @Override
    public List<Account> findAccount() {
        return findAccount(false);
    }

    @Override
    public List<Account> findAccount(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("No soup for you");
        }
        List<Account> myAccounts = new ArrayList<>();
        //Create sample accounts
        Account tempAccount1 = new Account("John", "Silver");
        Account tempAccount2 = new Account("Madhu", "Platinum");
        Account tempAccount3 = new Account("Luca", "Gold");
        myAccounts.add(tempAccount1);
        myAccounts.add(tempAccount2);
        myAccounts.add(tempAccount3);

        return myAccounts;
    }

    @Override
    public boolean doWork() {
        System.out.println("I DO WORK");
        return false;
    }
}
