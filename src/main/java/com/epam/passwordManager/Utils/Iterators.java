package com.epam.passwordManager.Utils;

import org.apache.logging.log4j.Level;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Iterators {
    private static PMTLogger log;

    public void underLine() {
        System.out.println("=======================================");
    }


    public boolean iterateOverGroups(User user) {
        PMTLogger.log(Level.INFO,"The accounts with the current user are: ");

        user.getUserGroupDetails().getUserGroups().keySet().stream().forEach(i->{
            iterateOverAccounts(user.getUserGroupDetails().getUserGroups().get(i), i);
        });
        underLine();
        return true;
    }

    public boolean iterateOverAccounts(Map<String, List<Account>> groupMap, String groupName) {
        AtomicInteger accountId = new AtomicInteger(1);
        PMTLogger.log(Level.INFO,"ID" + "         " + "Group Name" + "            " + "Account Name");

        groupMap.keySet().stream().forEach(i->{
            PMTLogger.log(Level.INFO, accountId.getAndIncrement() + "         " + groupName + "              " + i);
        });
        underLine();
        return true;
    }

    public boolean iterateOverUserName(List<Account> accountList) {
        log.log(Level.INFO,"The Username are as follows");

        AtomicInteger index = new AtomicInteger(1);
        log.log(Level.INFO,"ID" + "    " + "UserName" + "           " + "URL");
        accountList.stream().forEach(i->{
            PMTLogger.log(Level.INFO, index.getAndIncrement() + "    " + i.getUserName() + "           " + i.getUrl());
        });
        return true;
    }
}
