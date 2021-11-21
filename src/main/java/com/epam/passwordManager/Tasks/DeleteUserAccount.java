package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.*;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeleteUserAccount implements UserChoice{
    private Scanner sc;
    private Iterators iterators;
    private static User user;
    private static PMTLogger log;

    public DeleteUserAccount(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        UserGroupDetails userGroupDetails = user.getUserGroupDetails();
        if (userGroupDetails == null) {
            log.log(Level.INFO,"Sorry no account exits with the given name");
            return;
        }


        //Iterating through all the group associated with the user
        iterators.iterateOverGroups(user);

        log.log(Level.INFO,"Enter the group name you want to see");
        String groupName = sc.next();
        Map<String, List<Account>> map = userGroupDetails.getUserGroups().get(groupName);

        log.log(Level.INFO,"Enter the Account Name you want to see");
        String accountName = sc.next();

        log.log(Level.INFO,"Enter the id of the account you want to remove");
        List<Account> accounts = map.get(accountName);

        iterators.iterateOverUserName(accounts);

        int userAccountChoice = sc.nextInt();
        accounts.remove(userAccountChoice - 1);
        log.log(Level.INFO,"Account remove successfully!!!!");
        iterators.underLine();
    }
}
