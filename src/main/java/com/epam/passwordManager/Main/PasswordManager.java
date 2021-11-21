package com.epam.passwordManager.Main;

import com.epam.passwordManager.Exceptions.NoSuchGroupExistsException;
import com.epam.passwordManager.Tasks.UserChoice;
import com.epam.passwordManager.Tasks.Validations;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PasswordManager {
    private static Scanner sc;
    private static TaskFactory taskFactory;

    public PasswordManager(){
        sc= new Scanner(System.in);
        taskFactory= new TaskFactory();
    }


    private static void showChoices(){
        System.out.println("Enter your choice among the following");
        System.out.println("1. Create Password for an account");
        System.out.println("2. Read Password for an account");
        System.out.println("3. List all Password Account and groups");
        System.out.println("4. Delete Password Account");
        System.out.println("5. Modify or Update password Account");
        System.out.println("6. Modify Group details");
        System.out.println("7. Delete Group");
        System.out.println("8. Exit the app");
    }

    private static void welcome(){
        System.out.println("Welcome to Password Management Tool");
        System.out.println("Please enter your credentials to continue");
    }

    public void passwordManager() throws Exception {
        boolean firstTimeLogin = false;

        while (true) {
            try {
                //Show the welcome for the first time login
                if (!firstTimeLogin) {
                    welcome();
                    firstTimeLogin = true;
                    if (!new Validations().validateMasterPassword(sc.next())) {
                        System.out.println("Sorry Wrong Password");
                        firstTimeLogin = false;
                        continue;
                    }
                }
                showChoices();
                int choice = sc.nextInt();
                UserChoice userChoice= taskFactory.getInstance(choice);
                userChoice.execute();

            } catch (InputMismatchException e) {
                throw new InputMismatchException("Please enter a correct choice");
            } catch (NoSuchGroupExistsException e) {
                throw new NoSuchGroupExistsException("Sorry! No group or account exists with the given name.. Please try again.");
            }

        }
    }
}
