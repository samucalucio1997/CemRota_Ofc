package com.rota.cemrota.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rota.cemrota.model.PontoTuristico;

public interface PontoTuristicoRepository extends JpaRepository<PontoTuristico,UUID>{

}
