package com.rota.cemrota.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rota.cemrota.dto.UserTokenDTO;
import com.rota.cemrota.model.Usuario;
import com.rota.cemrota.security.TokenUtil;
import com.rota.cemrota.service.domain.UsuarioService;
import com.rota.cemrota.service.request.LoginRequest;
import com.rota.cemrota.service.request.UserRequest;

@RestController
@RequestMapping("/users")
public class UsuarioController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
        @RequestBody @Validated UserRequest userRequest,
        @RequestParam(value = "file", required = false) MultipartFile file
    ) throws IllegalStateException, IOException{
        try{
            Usuario newUser = new Usuario(userRequest);
            this.usuarioService.cadastrarUsuario(newUser, null);
            return ResponseEntity.ok().body("Usuário registrado com sucesso");
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        } 
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> getOne(@PathVariable UUID id){
        System.out.println(id);
        try{
            Optional<Usuario> user = this.usuarioService.getUsuario(id);
            return ResponseEntity.ok().body(user);
        } catch(Exception e){
            return (ResponseEntity<Optional<Usuario>>) ResponseEntity.notFound();
        }
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<UserTokenDTO> Login(@RequestBody LoginRequest usuario){
         try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario.username(), usuario.password());
            Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            var user = (Usuario) authentication.getPrincipal();
            String token = TokenUtil.EncodeT(user);
            UserTokenDTO userTokenDTO = new UserTokenDTO();
            userTokenDTO.setToken(token);
            userTokenDTO.setUsuario(user);
            return ResponseEntity.status(200).body(userTokenDTO);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(401).build();
         }
    }
}
