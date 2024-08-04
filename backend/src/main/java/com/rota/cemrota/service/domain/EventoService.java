package com.rota.cemrota.service.domain;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rota.cemrota.config.FilestorageProperties;
import com.rota.cemrota.model.Evento;
import com.rota.cemrota.repository.EventoRepository;

@Service
public class EventoService {

     private final Path camImgs;



    @Autowired
    private EventoRepository eventoRepository; 

    

    public EventoService(FilestorageProperties caminho) {
        this.camImgs = Paths.get(caminho.getUploadDir()).toAbsolutePath().normalize();
    }

    public List<Evento> findAll(){
        return eventoRepository.findAll();
    }
}
