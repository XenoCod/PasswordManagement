package com.epam.passwordManager.Exceptions;

import com.epam.passwordManager.Tasks.UserChoice;

public class PleaseEnterCorrectChoice extends Exception implements UserChoice {
    public PleaseEnterCorrectChoice(String err){
        super(err);
    }

    @Override
    public void execute() throws Exception {
        new PleaseEnterCorrectChoice("Please enter a correct choice");
    }
}
