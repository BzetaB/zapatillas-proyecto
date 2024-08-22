package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, Integer> {
}
