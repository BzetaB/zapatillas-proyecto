package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductoDto {
    private Integer idproducto;
    private String pname;
    private String pdesc;
    private Double pprecio;
    private Integer pstock;
    private Integer ptalla;
    private Integer idmarca;
    private Integer idcategoria;

}
