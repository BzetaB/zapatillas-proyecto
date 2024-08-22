package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

