package com.rota.cemrota.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private String email;

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public EmailValidator(String email){
        this.email = email;
    }

    public boolean isValidEmail() {
        Matcher matcher = pattern.matcher(this.email);
        return matcher.matches();
    }
}

