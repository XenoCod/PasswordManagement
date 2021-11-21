package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.PMTLogger;
import com.epam.passwordManager.Utils.User;
import org.apache.logging.log4j.Level;

import java.util.Scanner;

public class DeleteGroup implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;
    private static PMTLogger log;

    public DeleteGroup(){
        sc= new Scanner(System.in);
        iterators= new Iterators();
        user= User.getUser();
    }

    public void execute(){
        iterators.iterateOverGroups(user);

        log.log(Level.INFO,"Enter the group name you want to delete");
        String groupName = sc.next();

        user.getUserGroupDetails().getUserGroups().remove(groupName);
        log.log(Level.INFO,"Group deleted successfully!!!!");
        iterators.underLine();
    }
}
