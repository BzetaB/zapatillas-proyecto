package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@Setter
@Getter
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;

    private String username;

    private String password;

    private String nombrecliente;

    private String apellidocliente;

    private Boolean sexo;


    private Date fechanacimiento;

    private String emailcliente;

    private String telefonocliente;

    private String direccion;

    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "idtipodocumento")
    private TipoDocumentoCliente tipodocumentocliente;

    @ManyToOne
    @JoinColumn(name = "iddirecciondespacho")
    private DireccionDespacho direcciondespacho;

    @OneToMany(mappedBy = "cliente")
    private Set<Despacho> despacho;

    @OneToMany(mappedBy = "cliente")
    private Set<Comprobante> comprobante;



}
