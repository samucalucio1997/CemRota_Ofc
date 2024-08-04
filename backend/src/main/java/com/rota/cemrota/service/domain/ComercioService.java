package com.rota.cemrota.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rota.cemrota.model.Comercio;
import com.rota.cemrota.repository.ComercioRepository;

@Service
public class ComercioService {

   @Autowired 
   private ComercioRepository comercioRepository;

   public List<Comercio> findAll(){
    return this.comercioRepository.findAll();
   }
}
