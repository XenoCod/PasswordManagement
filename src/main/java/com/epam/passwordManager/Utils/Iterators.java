package com.epam.passwordManager.Utils;

import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Map;

public class Iterators {
    private static PMTLogger log;

    public void underLine() {
        System.out.println("=======================================");
    }


    public void iterateOverGroups(User user) {
        System.out.println("The accounts with the current user are: ");
        for (String groupName : user.getUserGroupDetails().getUserGroups().keySet()) {
            iterateOverAccounts(user.getUserGroupDetails().getUserGroups().get(groupName), groupName);
        }
//        user.getUserGroupDetails().getUserGroups().keySet().stream().
        underLine();
    }

    public void iterateOverAccounts(Map<String, List<Account>> groupMap, String groupName) {
        int accountId = 1;
        System.out.println("ID" + "         " + "Group Name" + "            " + "Account Name");
        for (String accountName : groupMap.keySet()) {
            log.log(Level.INFO,accountId + "         " + groupName + "              " + accountName);
            accountId++;
        }
        underLine();
    }

    public void iterateOverUserName(List<Account> accountList) {
        log.log(Level.INFO,"The Username are as follows");
        int index = 1;
        log.log(Level.INFO,"ID" + "    " + "UserName" + "           " + "URL");
        for (Account account : accountList) {
            log.log(Level.INFO,index + "    " + account.getUserName() + "           " + account.getUrl());
            index++;
        }
    }
}
