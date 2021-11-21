package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.User;
import com.epam.passwordManager.Utils.UserGroupDetails;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DeleteUserAccount implements UserChoice{
    private Scanner sc;
    private Iterators iterators;
    private static User user;

    public DeleteUserAccount(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        UserGroupDetails userGroupDetails = user.getUserGroupDetails();
        if (userGroupDetails == null) {
            System.out.println("Sorry no account exits with the given name");
            return;
        }


        //Iterating through all the group associated with the user
        iterators.iterateOverGroups(user);

        System.out.println("Enter the group name you want to see");
        String groupName = sc.next();
        Map<String, List<Account>> map = userGroupDetails.getUserGroups().get(groupName);

        System.out.println("Enter the Account Name you want to see");
        String accountName = sc.next();

        System.out.println("Enter the id of the account you want to remove");
        List<Account> accounts = map.get(accountName);

        iterators.iterateOverUserName(accounts);

        int userAccountChoice = sc.nextInt();
        accounts.remove(userAccountChoice - 1);
        System.out.println("Account remove successfully!!!!");
        iterators.underLine();
    }
}
