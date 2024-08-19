package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tipodocumentocliente")
public class TipoDocumentoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipodocumento;

    private String descripciondocumento;

    @OneToMany(mappedBy = "tipodocumentocliente")
    private Set<Cliente> cliente;
}
