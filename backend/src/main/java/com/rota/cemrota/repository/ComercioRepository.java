package com.rota.cemrota.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rota.cemrota.model.Comercio;

public interface ComercioRepository extends JpaRepository<Comercio,UUID>{

}
