package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.PMTLogger;
import com.epam.passwordManager.Utils.User;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Scanner;

public class UpdateAccount implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;
    private static PMTLogger log;

    public UpdateAccount(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        iterators.iterateOverGroups(user);

        log.log(Level.INFO,"Enter the group name of the account you want to modify");
        String groupName = sc.next();

        if (user.getUserGroupDetails().getUserGroups().get(groupName) == null) {
            log.log(Level.INFO, "Sorry no group exists with the given name");
            return;
        }
        log.log(Level.INFO,"Enter the account Name you want to update");
        String accountName = sc.next();


        log.log(Level.INFO,"Please enter the id of the account you want to update");
        List<Account> list = user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName);

        iterators.iterateOverUserName(list);

        int userAccountChoice = sc.nextInt();
        Account account = list.get(userAccountChoice - 1);
        log.log(Level.INFO,"Enter the new account name");
        String newAccountName = sc.next();
        account.setUserName(newAccountName);
        log.log(Level.INFO,"Account Updated successfully!!!!");
        iterators.underLine();
    }
}
