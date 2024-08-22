package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ComprobanteDto {
    private Integer idcomprobante;
    private Date fechacomprobante;
    private Double total;
    private Integer iddespacho;
    private Integer idcliente;
    private Integer idmetododepago;
}
