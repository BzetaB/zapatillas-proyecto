package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcolaborador;
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private Boolean sexo;
    private String correo;
    private String direccion;
    private String telefono;
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    private Boolean activo;


    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "colaborador_rol",
            joinColumns = @JoinColumn(name = "idcolaborador"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;



    //relacion entre colaborador y tipoDocumentoColaborador
    @ManyToOne
    @JoinColumn(name="iddocumento")
    private TipoDocumentoColaborador tipoDocumentoColaborador;


}
