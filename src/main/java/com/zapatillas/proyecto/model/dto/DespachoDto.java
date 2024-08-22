package com.zapatillas.proyecto.model.dto;

import com.zapatillas.proyecto.model.bd.Cliente;
import com.zapatillas.proyecto.model.bd.DireccionDespacho;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class DespachoDto {
    private Integer iddespacho;
    private Date fechadespacho;
    private String estadodespacho;
    private Cliente cliente; // Incluye cliente en el DTO
    private DireccionDespacho direccionDespacho;

    private Integer idcliente; // Referencia al cliente
    private Integer iddirecciondespacho; // Referencia a la dirección de despacho
}
