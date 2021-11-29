package com.epam.passwordManager.Main;

import com.epam.passwordManager.Tasks.PleaseEnterCorrectChoice;
import com.epam.passwordManager.Tasks.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskFactoryTest {

    static TaskFactory taskFactory= new TaskFactory();
//    @BeforeEach
//    public void setUp() throws Exception {
//        taskFactory= new TaskFactory();
//    }

    @Test
    public void canAddAccount(){
        AddAccountToUser addAccountToUser= new AddAccountToUser();
        assertEquals(taskFactory.getInstance(1).getClass(), addAccountToUser.getClass());
    }

    @Test
    public void canViewPassword(){
        ViewUserPassword viewUserPassword= new ViewUserPassword();
        assertEquals(taskFactory.getInstance(2).getClass(), viewUserPassword.getClass());
    }

    @Test
    public void canlistAllUserAccounts(){
        ListAllUserAccounts listAllUserAccounts= new ListAllUserAccounts();
        assertEquals(taskFactory.getInstance(3).getClass(), listAllUserAccounts.getClass());
    }

    @Test
    public void canDeleteUserAccount(){
        DeleteUserAccount deleteUserAccount= new DeleteUserAccount();
        assertEquals(taskFactory.getInstance(4).getClass(), deleteUserAccount.getClass());
    }

    @Test
    public void canUpdateAccount(){
        UpdateAccount updateAccount= new UpdateAccount();
        assertEquals(taskFactory.getInstance(5).getClass(), updateAccount.getClass());
    }

    @Test
    public void canUpdateGroupDetails(){
        UpdateGroupDetails updateGroupDetails= new UpdateGroupDetails();
        assertEquals(taskFactory.getInstance(6).getClass(), updateGroupDetails.getClass());
    }

    @Test
    public void canDeleteGroup(){
        DeleteGroup deleteGroup= new DeleteGroup();
        assertEquals(taskFactory.getInstance(7).getClass(), deleteGroup.getClass());
    }

    @Test
    public void ExceptionThrowForIncorrectChoice(){
        PleaseEnterCorrectChoice pleaseEnterCorrectChoice = new PleaseEnterCorrectChoice();
        assertEquals(taskFactory.getInstance(8).getClass(), pleaseEnterCorrectChoice.getClass());
    }


}