package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.EstadoVenta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoVentaRepository extends JpaRepository<EstadoVenta,Integer> {
    EstadoVenta findByEstado(String estado);

    @Transactional
    @Modifying
    @Query(value = "UPDATE estadoventa SET estado =:estado where "+
            "idestadoventa =:idestadoventa",nativeQuery = true)
    void actualizarEstadoVenta(@Param("estado") String estado,
                               @Param("idestadoventa") Integer idestadoventa);
}
