package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespuestaGeneral {
    private Boolean resultado;
    private String mensaje;
}
