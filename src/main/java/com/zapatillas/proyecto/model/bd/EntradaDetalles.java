package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entrada_detalle")
public class EntradaDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddetalle;

    private Integer cantidad;
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "identrada")
    private EntradaProducto entradaProducto;

    @ManyToOne
    @JoinColumn(name = "idproducto")
    private Producto producto;
}


