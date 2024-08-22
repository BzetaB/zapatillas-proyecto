package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClienteDto {
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
    private Integer idtipodocumento;
    private String descripciondocumento; // Descripción del tipo de documento (opcional)
    private Integer iddirecciondespacho;
    private String direcciondespacho; // Descripción de la dirección de despacho (opcional)
}
