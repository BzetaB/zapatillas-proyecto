package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "entrada_producto")
public class EntradaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idetdpro;

    private String etdpronombre;
    private String etdprodescripcion;
    private Double etdproprecio;
    private Integer etdprostock;

    @ManyToOne
    @JoinColumn(name = "idprovedor")
    private Provedor proveedor;
}
