package com.rota.cemrota.application.usecases.UsuarioUseCases;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.rota.cemrota.application.exceptions.userExceptions.EmailInvalidoException;
import com.rota.cemrota.application.exceptions.userExceptions.UsuarioExistenteException;
import com.rota.cemrota.application.exceptions.userExceptions.UsuarioInvalidoException;
import com.rota.cemrota.config.FilestorageProperties;
import com.rota.cemrota.model.Usuario;
import com.rota.cemrota.repository.UsuarioRepository;
import com.rota.cemrota.utils.EmailValidator;
import com.rota.cemrota.utils.PasswordEncode;

@Component
public class UsuarioRegister {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private Path fileStoraged;

    public UsuarioRegister() {
    }

    public UsuarioRegister(FilestorageProperties caminho) {
        this.fileStoraged = Paths.get(caminho.getUploadDir()).toAbsolutePath().normalize();
    }
    
    public void verifyNullParams(Usuario usuario){
        if(
            usuario.getUsername() == null || 
            usuario.getName() == null ||
            usuario.getEmail() == null ||
            usuario.getLastname() == null ||
            usuario.getPassword() == null
        ) {
            throw new UsuarioInvalidoException("Não é permitido campos nulos.");
        }
    }

    private void verifyUsuarioExists(Usuario usuario){
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw new UsuarioExistenteException("Usuário já cadastrado");
        }
    }

    private void validateEmail(Usuario usuario){
        EmailValidator emailValidator = new EmailValidator(usuario.getEmail());
        if (!emailValidator.isValidEmail()) {
            throw new EmailInvalidoException("E-mail inválido");
        }

        
    }

    @SuppressWarnings("null")
    private void saveProfileImg(Usuario usuario, MultipartFile file) throws IOException {
        if (file != null || !file.isEmpty()) {
            String path = file.getOriginalFilename();
            Path caminho = this.fileStoraged.resolve(path).toAbsolutePath().normalize();
            file.transferTo(caminho);
            usuario.setImgPerfil(path);
        }
    }

    

    private void passwordEncode(Usuario usuario){
        PasswordEncode passwordEncode = new PasswordEncode();
        passwordEncode.encode(usuario);
    }

    public Usuario registerUser(Usuario usuario, MultipartFile file) throws IOException{
        this.verifyNullParams(usuario);
        this.validateEmail(usuario);
        this.verifyUsuarioExists(usuario);
        if (file!=null) {
            this.saveProfileImg(usuario, file);
        }
        this.passwordEncode(usuario);
        return usuario;
    }
}
