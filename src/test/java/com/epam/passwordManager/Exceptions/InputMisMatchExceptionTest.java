package com.epam.passwordManager.Exceptions;

import com.epam.passwordManager.Main.PasswordManager;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InputMisMatchExceptionTest {
    @Test
public void isInputMisMatchException(){
    try{
        new PasswordManager().takeAndExceuteUserChoice(8);
    }
    catch (Exception e){
        assertThat(e.getMessage(), is("Please enter a correct choice"));

    }
}
}