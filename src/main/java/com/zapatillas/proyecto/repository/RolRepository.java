package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Rol;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol findByNombrerol(String nombrerol);

    @Transactional
    @Modifying
    @Query(value = "UPDATE rol SET nombrerol =:nombrerol where idrol =:idrol",nativeQuery = true)
    void actualizarRoles(@Param("nombrerol")String nombrerol,
                         @Param("idrol")Integer idrol);
}
