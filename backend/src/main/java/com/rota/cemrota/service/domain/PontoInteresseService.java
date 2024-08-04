package com.rota.cemrota.service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rota.cemrota.model.PontoInteresse;
import com.rota.cemrota.repository.PontoInteresseRepository;

@Service
public class PontoInteresseService {

    @Autowired
    private PontoInteresseRepository pontoInteresseRepository;

    public PontoInteresse cadastrarPonto(PontoInteresse ponto){
          PontoInteresse pontoInteresse = this.pontoInteresseRepository.findByTitulo(ponto.getTitulo()).stream().findFirst().get();
          if (pontoInteresse!=null) {
            throw new RuntimeException("Já existe esse Ponto");
          }
          return this.pontoInteresseRepository.save(ponto);
    }
}
