package com.epam.passwordManager.Utils;

import com.epam.passwordManager.Tasks.Validations;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class IteratorsTest {
    @Test
    public void canIterateOverAllGroups(){
        User user= new User();
        user.setUserName("Adi");
        Map<String , Map<String, List<Account>>> map= new HashMap<>();
        map.put("groupOne", new HashMap<>());
        map.get("groupOne").put("accountOne", new ArrayList<Account>());
        Account account= new Account();
        account.setUserName("Aks");
        account.setPassword("abc");
        map.get("groupOne").get("accountOne").add(account);
        UserGroupDetails userGroupDetails= new UserGroupDetails();
        userGroupDetails.setUserGroups(map);
        user.setUserGroupDetails(userGroupDetails);
        assertTrue(new Iterators().iterateOverGroups(user));
    }

    @Test
    public void canIterateOverAllAccounts(){
        User user= new User();
        user.setUserName("Adi");
        Map<String , Map<String, List<Account>>> map= new HashMap<>();
        map.put("groupOne", new HashMap<>());
        map.get("groupOne").put("accountOne", new ArrayList<Account>());
        Account account= new Account();
        account.setUserName("Aks");
        account.setPassword("abc");
        map.get("groupOne").get("accountOne").add(account);
        UserGroupDetails userGroupDetails= new UserGroupDetails();
        userGroupDetails.setUserGroups(map);
        user.setUserGroupDetails(userGroupDetails);
        assertTrue(new Iterators().iterateOverAccounts(map.get("groupOne") ,"groupOne"));
    }

    @Test
    public void canIterateOverAllName(){
        User user= new User();
        user.setUserName("Adi");
        Map<String , Map<String, List<Account>>> map= new HashMap<>();
        map.put("groupOne", new HashMap<>());
        map.get("groupOne").put("accountOne", new ArrayList<Account>());
        Account account= new Account();
        account.setUserName("Aks");
        account.setPassword("abc");
        map.get("groupOne").get("accountOne").add(account);
        UserGroupDetails userGroupDetails= new UserGroupDetails();
        userGroupDetails.setUserGroups(map);
        user.setUserGroupDetails(userGroupDetails);
        assertTrue(new Iterators().iterateOverUserName(map.get("groupOne").get("accountOne")));
    }
}