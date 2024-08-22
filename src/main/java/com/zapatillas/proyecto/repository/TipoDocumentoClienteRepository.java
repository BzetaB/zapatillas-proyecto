package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.TipoDocumentoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoClienteRepository extends JpaRepository<TipoDocumentoCliente, Integer> {
    TipoDocumentoCliente findByDescripciondocumento(String descripciondocumento);
}