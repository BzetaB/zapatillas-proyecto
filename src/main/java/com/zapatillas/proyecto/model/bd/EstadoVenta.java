package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "estadoventa")
public class EstadoVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestadoventa;
    private String estado;
}
