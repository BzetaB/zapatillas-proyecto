package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcomprobante;





    //relacion entre comprobante y metododepago
    @ManyToOne
    @JoinColumn(name = "idmetododepago")
    private MetodoDePago metodoDePago;

}
