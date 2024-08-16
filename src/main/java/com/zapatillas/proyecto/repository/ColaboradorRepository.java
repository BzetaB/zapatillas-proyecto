package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador,Integer> {
}
