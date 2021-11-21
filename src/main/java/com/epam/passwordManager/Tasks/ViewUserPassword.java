package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.*;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ViewUserPassword implements UserChoice {
    private Scanner sc;
    private Iterators iterators;
    private static User user;
    private static PMTLogger log;

    public ViewUserPassword(){
        iterators= new Iterators();
        sc= new Scanner(System.in);
        user= User.getUser();
    }

    public void execute(){
        //If there is no group with the user then simply return
        UserGroupDetails userGroupDetails = user.getUserGroupDetails();
        if (userGroupDetails == null) {
            log.log(Level.INFO,"Sorry No account exists with the given name");
            return;
        }

        iterators.iterateOverGroups(user);


        //Get the groupName and iterate through all the Accounts associated with the provided group
        log.log(Level.INFO,"Enter the group name you want to see");
        String groupName = sc.next();
        //Fetch the accounts associated with the group
        Map<String, List<Account>> accountsMap = userGroupDetails.getUserGroups().get(groupName);

        if (accountsMap.isEmpty()) {
            log.log(Level.INFO, "Sorry! There are no group for the current user. Please add an account");
            return;
        }

        log.log(Level.INFO,"Enter the Account Name you want to see");
        String accountName = sc.next();

        if (user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName).isEmpty()) {
            log.log(Level.INFO,"Sorry! There are no account linked with current user");
            return;
        }

        //Iterate through all the accounts
        log.log(Level.INFO,"Enter the id of the account you want to see");
        List<Account> accounts = accountsMap.get(accountName);

        iterators.iterateOverUserName(accounts);

        int userAccountChoice = sc.nextInt();

        byte[] decryptedPassword = accounts.get(userAccountChoice - 1).getEncryptedPassword();
        log.log(Level.INFO,"The encrypted password for the account " + accountName + "is " + decryptedPassword);
        log.log(Level.INFO,"Enter the master password to view the decrypted password");
        if (new Validations().validateMasterPassword(sc.next())) {
            log.log(Level.INFO,"The password for " + accountName + " is " + accounts.get(userAccountChoice - 1).getPassword());
        } else {
            log.log(Level.INFO,"Sorry you entered a wrong password. Please try again");
        }

       iterators.underLine();
    }
}
