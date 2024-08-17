package com.zapatillas.proyecto.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ColaboradorDto {
    private Integer idcolaborador;
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private String correo;
    private Date fechaingreso;
    private Boolean activo;
    private Integer idrol;
    private String nombrerol;
    private Integer iddocumento;
    private String nombredocumento;
}
