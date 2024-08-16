package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoColaboradorRepository
        extends JpaRepository<TipoDocumentoColaborador,Integer> {
    TipoDocumentoColaborador findByNombredocumento(String nombredocumento);
}
