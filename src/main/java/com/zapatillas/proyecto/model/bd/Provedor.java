package com.zapatillas.proyecto.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "provedor")
public class Provedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idprovedor;
    private String proname;
    private String prodireccion;
    private String protelefono;
    private String proemail;
    private String procontacto;
}
