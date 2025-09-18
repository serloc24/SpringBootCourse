package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
        return runner ->{
            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        //call the business method
        System.out.println("Calling the account method");
        Account myAccount = new Account();
        myAccount.setName("Hello World");
        System.out.println("this is the account name: " + myAccount.getName());
        theAccountDAO.addAccount(myAccount);
        theAccountDAO.doWork();
        System.out.println("We are doing with membership");
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();


    }

}
