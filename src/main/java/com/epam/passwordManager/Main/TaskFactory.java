package com.epam.passwordManager.Main;

import com.epam.passwordManager.Exceptions.PleaseEnterCorrectChoice;
import com.epam.passwordManager.Tasks.*;

import java.util.HashMap;
import java.util.Map;

public class TaskFactory {

    private static Map<Integer, UserChoice> map;

    public TaskFactory() {
        map = new HashMap<>();
        map.put(1, new AddAccountToUser());
        map.put(2, new ViewUserPassword());
        map.put(3, new ListAllUserAccounts());
        map.put(4, new DeleteUserAccount());
        map.put(5, new UpdateAccount());
        map.put(6, new UpdateGroupDetails());
        map.put(7, new DeleteGroup());
    }

    public UserChoice getInstance(int choice) {
        return map.getOrDefault(choice, new PleaseEnterCorrectChoice("Please enter a correct choice"));

    }
}
