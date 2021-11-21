package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UpdateGroupDetails implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;

    public UpdateGroupDetails(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        iterators.iterateOverGroups(user);

        System.out.println("Enter the group name you want to update");
        String groupName = sc.next();

        Map<String, List<Account>> map = user.getUserGroupDetails().getUserGroups().get(groupName);
        if (map == null) {
            System.out.println("Sorry no group exists with the given name");
            return;
        }

        System.out.println("Enter the new Group name");
        String newGroupName = sc.next();
        user.getUserGroupDetails().getUserGroups().remove(groupName);
        user.getUserGroupDetails().getUserGroups().put(newGroupName, map);
        System.out.println("Group name updated successfully!!!!");
        iterators.underLine();
    }
}
