package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.EstadoVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVentaRepository extends JpaRepository<EstadoVenta,Integer> {
}
