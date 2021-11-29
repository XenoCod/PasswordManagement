//package com.epam.passwordManager.Tasks;
//
//import com.epam.passwordManager.Utils.Account;
//import com.epam.passwordManager.Utils.User;
//import com.epam.passwordManager.Utils.UserGroupDetails;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//public class ListAllUserAccountsTest {
//    @Test
//    public void canListAllAccounts(){
//        User user= new User();
//        user.setUserName("Adi");
//        Map<String , Map<String, List<Account>>> map= new HashMap<>();
//        map.put("groupOne", new HashMap<>());
//        map.get("groupOne").put("accountOne", new ArrayList<Account>());
//        Account account= new Account();
//        account.setUserName("Aks");
//        account.setPassword("abc");
//        map.get("groupOne").get("accountOne").add(account);
//        UserGroupDetails userGroupDetails= new UserGroupDetails();
//        userGroupDetails.setUserGroups(map);
//        user.setUserGroupDetails(userGroupDetails);
//
//        assertTrue(new ListAllUserAccounts().listAllAccounts(user));
//    }
//}