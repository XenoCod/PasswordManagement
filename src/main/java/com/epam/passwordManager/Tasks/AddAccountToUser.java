package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Utils.Account;
import com.epam.passwordManager.Utils.Iterators;
import com.epam.passwordManager.Utils.User;
import com.epam.passwordManager.Utils.UserGroupDetails;

import java.util.*;

public class AddAccountToUser implements UserChoice {

    private Scanner sc;
    private Iterators iterators;
    private static User user;

    public AddAccountToUser() {
        iterators = new Iterators();
        sc = new Scanner(System.in);
        user = User.getUser();
    }


    public void execute() throws Exception {
        //Setting the username
        System.out.println("Enter the Master Username");
        String masterUserName = sc.next();
        user.setUserName(masterUserName);

        //Checking if the current user already has a group or not
        UserGroupDetails userGroupDetails;
        if (user.getUserGroupDetails() == null) {
            user.setUserGroupDetails(new UserGroupDetails());
        }
        userGroupDetails = user.getUserGroupDetails();


        //Take the user group name
        System.out.println("A Group name should only contains Alphabets");
        System.out.println("Enter the Group name");
        String groupName = sc.next();

        //If the provided groupName contains digit then simply return
        if (!new Validations().checkIfStringHasOnlyChars(groupName)) {
            System.out.println("Sorry!, The provided groupName contains digits. Please provided only Characters");
            return;
        }


        //Take the user current account name
        System.out.println("Account Name should only consists of Alphabets");
        System.out.println("Enter your Account name");
        String accountName = sc.next();

        //Take the userName from the user
        System.out.println("Enter your Username. Please enter a unique User Name");
        String userName = sc.next();


        if (!new Validations().checkIfStringHasOnlyChars(accountName)) {
            System.out.println("The provided account Name contains digits. Please enter only alphabets and try again");
            return;
        }


        System.out.println("Press 1. If you want to enter your password \nPress 2. If you want to generate random password");
        int userPasswordChoice = sc.nextInt();
        String password = "";

        //If user want to use his own password
        if (userPasswordChoice == 1) {
            System.out.println("Enter your password");
            password = sc.next();
        }

        //If the user wants to generate a random password
        else if (userPasswordChoice == 2) {
            //Generate a random password for the user and store it
            System.out.println("Enter the password length for your password");
            int passwordLen = sc.nextInt();
            System.out.println("Enter tht characters for your password as a String");
            String passwordUserChars = sc.next();
            password = generateRandomPassword(passwordLen, passwordUserChars);
        }

        //Create a new Account for the user according to the user password and username
        Account account = new Account();
        account.setUserName(userName);
        account.setUrl("www.".concat(accountName).concat(".com"));
        account.setPassword(password);
        account.setEncryptedPassword(new Encryption().encrypt(password));

        //Perform some user validation check to prevent null pointer exception
        userValidationsChecks(userGroupDetails, groupName, accountName);


        //If in the group the provided credentials already exits then simply return without adding
        if (user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName).contains(account)) {
            System.out.println("This user Name is already present. Please try again with a different name");
            return;
        }
        //Add account to the provided groupName and accountName
        user.getUserGroupDetails().getUserGroups().get(groupName).get(accountName).add(account);
//        user.setUserGroupDetails(userGroupDetails);
        System.out.println("Account added successfully!!!!");

        iterators.underLine();
    }

    public void userValidationsChecks(UserGroupDetails userGroupDetails, String groupName, String accountName) {
        //If the current user has no group associated with it then add a new HashMap
        if (user.getUserGroupDetails().getUserGroups() == null) {
            userGroupDetails.setUserGroups(new HashMap<String, Map<String, List<Account>>>());
        }

        //If the current user does not contains the provided groupName then add a new HashMap with the given groupName
        if (!user.getUserGroupDetails().getUserGroups().containsKey(groupName)) {
            userGroupDetails.getUserGroups().put(groupName, new HashMap<String, List<Account>>());
        }

        //If the current groupName has no accountName associated with it then add a new HashMap to it with the provided accountName
        if (!user.getUserGroupDetails().getUserGroups().get(groupName).containsKey(accountName)) {
            userGroupDetails.getUserGroups().get(groupName).put(accountName, new ArrayList<Account>());
        }
    }

    public String generateRandomPassword(int len, String userChars) {
        Random random = new Random();
        StringBuilder randomPassword = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            randomPassword.append(userChars.charAt(random.nextInt(userChars.length())));
        }
        return randomPassword.toString();
    }
}
