package com.epam.passwordManager.Utils;

import java.util.List;
import java.util.Map;

public class Iterators {

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
            System.out.println(accountId + "         " + groupName + "              " + accountName);
            accountId++;
        }
        underLine();
    }

    public void iterateOverUserName(List<Account> accountList) {
        System.out.println("The Username are as follows");
        int index = 1;
        System.out.println("ID" + "    " + "UserName" + "           " + "URL");
        for (Account account : accountList) {
            System.out.println(index + "    " + account.getUserName() + "           " + account.getUrl());
            index++;
        }
    }
}
