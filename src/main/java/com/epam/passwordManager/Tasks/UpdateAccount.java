package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.User;

import java.util.List;
import java.util.Scanner;

public class UpdateAccount implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;

    public UpdateAccount(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        iterators.iterateOverGroups(user);

        System.out.println("Enter the group name of the account you want to modify");
        String groupName = sc.next();

        if (user.getUserGroupDetails().getUserGroups().get(groupName) == null) {
            System.out.println("Sorry no group exists with the given name");
            return;
        }
        System.out.println("Enter the account Name you want to update");
        String accountName = sc.next();


        System.out.println("Please enter the id of the account you want to update");
        List<Account> list = user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName);

        iterators.iterateOverUserName(list);

        int userAccountChoice = sc.nextInt();
        Account account = list.get(userAccountChoice - 1);
        System.out.println("Enter the new account name");
        String newAccountName = sc.next();
        account.setUserName(newAccountName);
        System.out.println("Account Updated successfully!!!!");
        iterators.underLine();
    }
}
