package com.rota.cemrota.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PasswordValidator {
    private String password;

    public PasswordValidator (String password){
        this.password = password;
    }

    public boolean isPasswordValid() {
        if(this.password.length() < 6) return false;
        String regex = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).*$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.password);

        return matcher.matches();
    }
}
