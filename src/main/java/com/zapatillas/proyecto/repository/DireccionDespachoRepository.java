package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.DireccionDespacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionDespachoRepository extends JpaRepository<DireccionDespacho, Integer> {

}
