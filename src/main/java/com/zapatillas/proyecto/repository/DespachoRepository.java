package com.zapatillas.proyecto.repository;

import com.zapatillas.proyecto.model.bd.Despacho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DespachoRepository extends JpaRepository<Despacho, Integer> {

    // Método para encontrar despachos por estado
    List<Despacho> findByEstadodespacho(String estado);

    // Método para encontrar despachos por fecha
    List<Despacho> findByFechadespacho(Date fecha);

    // Puedes añadir más métodos personalizados aquí si es necesario
}
