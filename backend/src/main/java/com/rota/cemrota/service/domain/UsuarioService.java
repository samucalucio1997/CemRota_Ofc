package com.rota.cemrota.service.domain;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.rota.cemrota.application.usecases.UsuarioUseCases.UsuarioRegister;
import com.rota.cemrota.model.Usuario;
import com.rota.cemrota.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioRegister userRegister;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        return (UserDetails) usuarioRepository.findByEmail(email);
    }

    public Optional<Usuario> getUsuario(UUID id){
        return this.usuarioRepository.findById(id);
    }

    public Usuario cadastrarUsuario(Usuario usuario, MultipartFile file) throws IOException {
        Usuario newUser = this.userRegister.registerUser(usuario, file);
        return this.usuarioRepository.save(newUser);
    }

}
