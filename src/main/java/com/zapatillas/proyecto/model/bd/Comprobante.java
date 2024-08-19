package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomprobante;
    @Temporal(TemporalType.DATE)
    private Date fechacomprobante;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "iddespacho")
    private Despacho despacho;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;


    //relacion entre comprobante y metododepago
    @ManyToOne
    @JoinColumn(name = "idmetododepago")
    private MetodoDePago metodoDePago;

}
