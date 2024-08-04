package com.rota.cemrota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rota.cemrota.model.Usuario;
import com.rota.cemrota.security.Login;
import com.rota.cemrota.security.TokenUtil;
import com.rota.cemrota.service.request.LoginRequest;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        try{
            Login user = new Login(loginRequest);
            UsernamePasswordAuthenticationToken uPasswordAuthenticationToken = 
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            AuthenticationManager auth = (AuthenticationManager) this.authenticationManager.authenticate(uPasswordAuthenticationToken);
            var userAuth = (Usuario)auth.authenticate(uPasswordAuthenticationToken).getPrincipal();
            return ResponseEntity.ok(TokenUtil.EncodeT(userAuth));
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Nome de usuário ou senha inválido(s)");
        }
    }
}
