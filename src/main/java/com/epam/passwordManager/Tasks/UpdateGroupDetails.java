package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.PMTLogger;
import com.epam.passwordManager.Utils.User;
import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UpdateGroupDetails implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;
    private static PMTLogger log;

    public UpdateGroupDetails(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        iterators.iterateOverGroups(user);

        log.log(Level.INFO,"Enter the group name you want to update");
        String groupName = sc.next();

        Map<String, List<Account>> map = user.getUserGroupDetails().getUserGroups().get(groupName);
        if (map == null) {
            log.log(Level.INFO,"Sorry no group exists with the given name");
            return;
        }

        log.log(Level.INFO,"Enter the new Group name");
        String newGroupName = sc.next();
        user.getUserGroupDetails().getUserGroups().remove(groupName);
        user.getUserGroupDetails().getUserGroups().put(newGroupName, map);
        log.log(Level.INFO,"Group name updated successfully!!!!");
        iterators.underLine();
    }
}
