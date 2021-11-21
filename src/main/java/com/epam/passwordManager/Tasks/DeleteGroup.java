package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.User;

import java.util.Scanner;

public class DeleteGroup implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;

    public DeleteGroup(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        iterators.iterateOverGroups(user);

        System.out.println("Enter the group name you want to delete");
        String groupName = sc.next();

        user.getUserGroupDetails().getUserGroups().remove(groupName);
        System.out.println("Group deleted successfully!!!!");
        iterators.underLine();
    }
}
