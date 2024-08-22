package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "despacho")
public class Despacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddespacho;

    @Temporal(TemporalType.DATE)
    private Date fechadespacho;

    private String estadodespacho;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "iddirecciondespacho")
    private DireccionDespacho direccionDespacho;


}
