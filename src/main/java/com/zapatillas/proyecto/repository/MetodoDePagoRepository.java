package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.MetodoDePago;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoDePagoRepository extends JpaRepository<MetodoDePago, Integer> {
    MetodoDePago findByMetodopago(String metodopago);

    @Transactional
    @Modifying
    @Query(value = "UPDATE metododepago SET metodopago =:metodopago where "+
            "idmetododepago =:idmetododepago",nativeQuery = true)
    void actualizarMetodoPago(@Param("metodopago") String metodopago,
                               @Param("idmetododepago") Integer idmetododepago);
}
