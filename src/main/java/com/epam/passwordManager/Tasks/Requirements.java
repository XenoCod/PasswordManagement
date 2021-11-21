package com.epam.passwordManager.Tasks;

public interface Requirements {
    public void addAccount() throws Exception;
    public void listAccounts();
    public void deleteAccount();
    public void updateAccount();
    public void updateGroupDetails();
    public void deleteGroup();
}
