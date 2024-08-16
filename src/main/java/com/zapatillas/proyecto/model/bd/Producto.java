package com.zapatillas.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproducto;










    //relacion entre producto y VentaDetalles
    @OneToMany(mappedBy = "producto",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<VentaDetalles> ventas = new HashSet<>();
}
