package com.rota.cemrota.service.domain;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rota.cemrota.model.Atrativo;
import com.rota.cemrota.repository.AtrativoRepository;

@Service
public class AtrativoService {

    @Autowired
    private AtrativoRepository atrativoRepository;

    public List<Atrativo> getAllAtrativos() {
        return atrativoRepository.findAll();
    }

    public Atrativo getAtrativoById(UUID id) {
        return atrativoRepository.findById(id).orElse(null);
    }

    public Atrativo createAtrativo(Atrativo atrativo) {
        return atrativoRepository.save(atrativo);
    }

    public Atrativo updateAtrativo(UUID id, Atrativo atrativo) {
        return atrativo;
    }

    public boolean deleteAtrativo(UUID id) {
        if (atrativoRepository.existsById(id)) {
            atrativoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}