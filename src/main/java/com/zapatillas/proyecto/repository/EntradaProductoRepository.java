package com.zapatillas.proyecto.repository;


import com.zapatillas.proyecto.model.bd.EntradaProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaProductoRepository extends JpaRepository<EntradaProducto, Integer> {
}
