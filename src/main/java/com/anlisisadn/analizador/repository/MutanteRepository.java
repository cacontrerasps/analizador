package com.anlisisadn.analizador.repository;

import com.anlisisadn.analizador.model.Mutante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MutanteRepository extends JpaRepository<Mutante, Integer> {
}
