package com.epam.passwordManager.Utils;

import com.epam.passwordManager.Tasks.Validations;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class UserTest {
    static Validations validations= new Validations();
    @Test
    public void validateUserPassword(){
        boolean resPassword= validations.validateMasterPassword("user@123");
        assertTrue(resPassword);
    }

    @Test
    public void inValidUserPassword(){
        boolean resInvalidPassword1= validations.validateMasterPassword("user");
        boolean resInvalidPassword2= validations.validateMasterPassword("user@12");
        assertFalse(resInvalidPassword1);
        assertFalse(resInvalidPassword2);
    }

}