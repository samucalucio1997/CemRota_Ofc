package com.rota.cemrota.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rota.cemrota.model.Atrativo;

import java.util.UUID;

@Repository
public interface AtrativoRepository extends JpaRepository<Atrativo, UUID> {
    // Se necessário, adicione métodos personalizados aqui
}
