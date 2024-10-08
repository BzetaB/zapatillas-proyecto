package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipodocumentocolaborador")
public class TipoDocumentoColaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iddocumento;
    private String nombredocumento;
}
