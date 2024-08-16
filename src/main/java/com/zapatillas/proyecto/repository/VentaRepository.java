package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
