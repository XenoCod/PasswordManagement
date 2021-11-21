package com.epam.passwordManager.Utils;

import java.util.List;
import java.util.Map;

public class UserGroupDetails {
    //Acting as a demo database
    //Structure: Map<GroupName, Map<AccountName, List<Account>>>
    private Map<String, Map<String, List<Account>>> userGroups;

    public void setUserGroups(Map<String, Map<String, List<Account>>> userGroups) {
        this.userGroups = userGroups;
    }

    public Map<String, Map<String, List<Account>>> getUserGroups() {
        return userGroups;
    }
}
