package com.rota.cemrota.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rota.cemrota.model.Hospedagem;

public interface HospedagemRepository extends JpaRepository<Hospedagem,UUID>{

}
