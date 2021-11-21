package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.User;
import com.epam.passwordManager.Utils.UserGroupDetails;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ListAllUserAccounts implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;

    public ListAllUserAccounts(){
        iterators= new Iterators();
        sc= new Scanner(System.in);
        user= User.getUser();
    }

    public void execute(){
        UserGroupDetails userGroupDetails = user.getUserGroupDetails();
        if (userGroupDetails == null) {
            System.out.println("Sorry No accounts exists with the given name");
            return;
        }

        //Iterating through all the group associated with the user
        iterators.iterateOverGroups(user);

        System.out.println("Enter the group name you want to see");
        String groupName = sc.next();
        Map<String, List<Account>> map = userGroupDetails.getUserGroups().get(groupName);

        if (map.isEmpty()) {
            System.out.println("Sorry! There are no group for the current user. Please add an account");
            return;
        }

        System.out.println("Enter the Account Name you want to see");
        String accountName = sc.next();

        if (user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName).isEmpty()) {
            System.out.println("Sorry! There are no account linked with current user");
            return;
        }

        //Iterate over the all the userID of the given accountName
        iterators.iterateOverUserName(map.get(accountName));

        iterators.underLine();
    }
}
