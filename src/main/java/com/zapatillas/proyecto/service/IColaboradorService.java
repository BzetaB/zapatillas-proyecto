package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.model.dto.ColaboradorDto;

import java.util.List;

public interface IColaboradorService {
    Colaborador obtenerColaboradorPorUsername(String username);
    void guardarColaborador(ColaboradorDto colaboradorDto);
    void actualizarColab(ColaboradorDto colaboradorDto);
    void eliminarColaboradorPorId(Integer id);
    List<Colaborador> listarColaboradores();
    Colaborador obtenerColaboradorPorId(Integer id);

}
