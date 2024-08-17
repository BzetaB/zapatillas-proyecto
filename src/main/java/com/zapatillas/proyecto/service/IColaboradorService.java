package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.model.dto.ColaboradorDto;

import java.util.List;

public interface IColaboradorService {
    Colaborador obtenerColaboradorPorUsername(String username);
    void guardarColaborador(ColaboradorDto colaboradorDto);
    List<Colaborador> listarColaboradores();
    Colaborador obtenerColaboradorPorId(Integer id);
    void actualizarColaborador(Colaborador colaborador);
}
