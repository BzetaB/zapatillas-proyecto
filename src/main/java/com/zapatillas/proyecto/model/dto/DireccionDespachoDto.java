package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DireccionDespachoDto {
    private Integer iddirecciondespacho;
    private String direccion;
    private String ciudad;
    private String codigopostal;
}
