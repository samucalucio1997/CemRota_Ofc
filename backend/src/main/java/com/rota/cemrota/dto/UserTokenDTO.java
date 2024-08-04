package com.rota.cemrota.dto;

import com.rota.cemrota.model.Usuario;

import lombok.Getter;
import lombok.Setter;

public class UserTokenDTO {
     @Getter
     @Setter
     private String token;
     @Getter
     @Setter
     private Usuario usuario;

     
}
