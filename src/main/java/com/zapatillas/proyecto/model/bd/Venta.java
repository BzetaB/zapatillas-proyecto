package com.zapatillas.proyecto.model.bd;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idventa;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Double descuento;
    private Double total;
    private Double igv;

    @ManyToOne
    @JoinColumn(name = "idestadoventa")
    private EstadoVenta estadoVenta;


    //relacion entre venta y VentaDetalles
    @OneToMany(mappedBy = "venta",
            cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<VentaDetalles> productos = new HashSet<>();

}
