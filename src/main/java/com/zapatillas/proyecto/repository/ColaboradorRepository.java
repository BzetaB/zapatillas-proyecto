package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Colaborador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Integer> {
    Colaborador findByUsername(String username);
}
