package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.*;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListAllUserAccounts implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;
    private static PMTLogger log;

    public ListAllUserAccounts(){
        iterators= new Iterators();
        sc= new Scanner(System.in);
        user= User.getUser();
    }

    public boolean execute(){
       listAllAccounts(user);
        return true;
    }

    public boolean listAllAccounts(User user){
        UserGroupDetails userGroupDetails = user.getUserGroupDetails();
        if (userGroupDetails == null) {
            log.log(Level.INFO,"Sorry No accounts exists with the given name");
            return false;
        }

        //Iterating through all the group associated with the user
        iterators.iterateOverGroups(user);

        log.log(Level.INFO,"Enter the group name you want to see");
        String groupName = sc.next();
        Map<String, List<Account>> map = userGroupDetails.getUserGroups().get(groupName);

        if (map.isEmpty()) {
            log.log(Level.INFO,"Sorry! There are no group for the current user. Please add an account");
            return false;
        }

        log.log(Level.INFO,"Enter the Account Name you want to see");
        String accountName = sc.next();

        if (user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName).isEmpty()) {
            log.log(Level.INFO,"Sorry! There are no account linked with current user");
            return false;
        }

        //Iterate over the all the userID of the given accountName
        iterators.iterateOverUserName(map.get(accountName));

        iterators.underLine();
        return true;
    }

}
