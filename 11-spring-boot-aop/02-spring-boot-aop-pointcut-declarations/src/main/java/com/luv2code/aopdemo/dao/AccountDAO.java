package com.luv2code.aopdemo.dao;


import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account theAccount);

    List<Account> findAccount();
    List<Account> findAccount(boolean tripWire);

    boolean doWork();

    public String getName();
    public void setName(String name);
    public String getServiceCode();
    public void setServiceCode(String serviceCode);


}
