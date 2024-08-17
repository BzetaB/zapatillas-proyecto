package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class VentaDto {
    private Integer idventa;
    private Integer idestadoventa;
    private String estado;
}
