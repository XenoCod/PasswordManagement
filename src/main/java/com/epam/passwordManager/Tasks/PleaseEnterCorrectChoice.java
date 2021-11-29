package com.epam.passwordManager.Tasks;

import com.epam.passwordManager.Exceptions.IncorrectChoice;

public class PleaseEnterCorrectChoice implements UserChoice {

    @Override
    public boolean execute() throws Exception {
        throw  new IncorrectChoice("Please enter a correct choice");
    }
}
