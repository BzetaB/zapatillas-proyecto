package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoColaboradorRepository
        extends JpaRepository<TipoDocumentoColaborador,Integer> {
    TipoDocumentoColaborador findByNombredocumento(String nombredocumento);

    @Transactional
    @Modifying
    @Query(value = "UPDATE tipodocumentocolaborador SET nombredocumento =:nombredocumento where iddocumento =:iddocumento",nativeQuery = true)
    void actualizarTipoDocumentoColaborador(@Param("nombredocumento")String nombredocumento,
                         @Param("iddocumento")Integer iddocumento);
}
