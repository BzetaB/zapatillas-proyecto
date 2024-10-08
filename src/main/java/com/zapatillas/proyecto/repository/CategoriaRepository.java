package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Categoria findByCatename(String catename);
}

