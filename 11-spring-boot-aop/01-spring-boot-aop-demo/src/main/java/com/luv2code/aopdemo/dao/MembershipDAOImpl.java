package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addAccount() {
        System.out.println(getClass() + " : DOING MY DB WORK AT MEMBERSHIP");return true;
    }

    @Override
    public void goToSleep() {
        System.out.println("Im tired, im going to sleep");
    }
}
