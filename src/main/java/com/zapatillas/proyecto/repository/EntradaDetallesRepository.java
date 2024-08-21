package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.EntradaDetalles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaDetallesRepository extends JpaRepository<EntradaDetalles, Integer> {
}

