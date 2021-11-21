package com.epam.passwordManager.Utils;

public class User {
    private UserGroupDetails userGroupDetails;
    private String userName;
    private String password;
    private static User user;

    public static User getUser(){
        if(user == null){
            user= new User();
        }
        return user;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserGroupDetails(UserGroupDetails userGroupDetails) {
        this.userGroupDetails = userGroupDetails;
    }

    public UserGroupDetails getUserGroupDetails() {
        return userGroupDetails;
    }
}
