package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Provedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvedorRepository extends JpaRepository<Provedor, Integer> {
}


