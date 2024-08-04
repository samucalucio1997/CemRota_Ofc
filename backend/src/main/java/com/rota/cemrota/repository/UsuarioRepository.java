package com.rota.cemrota.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rota.cemrota.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,UUID>{
    
   Usuario findByEmail(String email);
   Usuario findByUsername(String username);
}
