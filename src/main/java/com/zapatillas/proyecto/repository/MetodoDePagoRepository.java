package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.MetodoDePago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago, Integer> {
    MetodoDePago findByMetodopago(String metodopago);
}
