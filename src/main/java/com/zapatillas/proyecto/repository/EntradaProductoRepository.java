package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.EntradaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaProductoRepository extends JpaRepository<EntradaProducto, Integer> {
}


