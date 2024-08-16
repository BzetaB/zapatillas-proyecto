package com.zapatillas.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.zapatillas.proyecto.model.bd.pk.VentaProductoId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "detalleventa")
public class VentaDetalles {
    @EmbeddedId
    private VentaProductoId id;
    private Integer cantidad;
    private Double precio;
    private Double subtotal;

    @ManyToOne
    @MapsId("idproducto")
    @JoinColumn(name = "idproducto")
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @MapsId("idventa")
    @JoinColumn(name = "idventa")
    @JsonBackReference
    private Venta venta;

}
