package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService){
        return runner ->{
            /*
            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
            demoTheAfterReturningAdvice(theAccountDAO);
            demoTheAfterThrowingAdvice(theAccountDAO);
            */

            demoAroundGetFortune(theTrafficFortuneService);

        };
    }

    private void demoAroundGetFortune(TrafficFortuneService theTrafficFortuneService) {
        System.out.println("Main Program: Around Get fortune");
        System.out.println(theTrafficFortuneService.getFortune());
        System.out.println("Finished");

    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> theAccounts = null;
        try{
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccount(tripWire);
        } catch (Exception e) {
            System.out.println("Main Program: .. Exception Catched" + e);
        }

        System.out.println("=> Main Program: demoTheAfterThrowingAdvice");
        if (theAccounts != null) {
            for (Account a : theAccounts){
                System.out.println(a);
            }
        }else System.out.println("La lista de cuentas esta vacia");
        System.out.println("\n\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        //Call the method to find the account

        List<Account> theAccounts = theAccountDAO.findAccount();
        System.out.println("=> Main Program: demoTheAfterReturningAdvice");
        for (Account a : theAccounts){
            System.out.println(a);
        }

    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        //call the business method
        System.out.println("Calling the account method");
        Account myAccount = new Account();
        myAccount.setName("Madhu");
        myAccount.setLevel("Platinum");
        theAccountDAO.addAccount(myAccount);
        theAccountDAO.doWork();

        //Call the account getter/Setter methods
        System.out.println("\n\nDoing the getter/setter modes");
        theAccountDAO.setName("Foobar");
        theAccountDAO.setServiceCode("Silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        System.out.println("\n\nWe are doing with membership");
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();


    }

}
