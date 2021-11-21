package com.epam.passwordManager.Tasks;

public class Validations {

    public boolean validateMasterPassword(String password){
        return password.equals("user@123");
    }

    public boolean checkIfStringHasOnlyChars(String s){
        for(int i=0; i< s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
