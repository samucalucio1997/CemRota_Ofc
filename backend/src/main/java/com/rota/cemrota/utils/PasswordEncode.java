package com.rota.cemrota.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rota.cemrota.application.exceptions.userExceptions.SenhaInvalidaException;
import com.rota.cemrota.model.Usuario;

public class PasswordEncode {
    public void encode(Usuario usuario) {
        validatePassword(usuario);
        String encodedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
    }

    private void validatePassword(Usuario usuario){
        PasswordValidator passwordValidator = new PasswordValidator(usuario.getPassword());
        if(!passwordValidator.isPasswordValid())
         throw new SenhaInvalidaException("Senha inválida.");
     }
}
