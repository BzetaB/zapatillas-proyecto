package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "direcciondespacho")
public class DireccionDespacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddirecciondespacho;

    private String direccion;

    private String ciudad;

    private String codigopostal;

    // Relación bidireccional con Despacho
    @OneToMany(mappedBy = "direccionDespacho")
    private Set<Despacho> despachos;
}
