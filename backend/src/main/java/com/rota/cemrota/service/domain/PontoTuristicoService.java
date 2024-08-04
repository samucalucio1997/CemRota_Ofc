package com.rota.cemrota.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rota.cemrota.model.PontoTuristico;
import com.rota.cemrota.repository.PontoTuristicoRepository;

@Service
public class PontoTuristicoService {
    @Autowired
    private PontoTuristicoRepository pontoTuristicoRepository;
    
    public List<PontoTuristico> findAll(){
        return this.pontoTuristicoRepository.findAll();
    }
}
