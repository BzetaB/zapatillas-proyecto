package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Colaborador;

import java.util.List;

public interface IColaboradorService {
    Colaborador obtenerColaboradorPorUsername(String username);
    Colaborador guardarColaborador(Colaborador colaborador);
    List<Colaborador> listarColaboradores();
    Colaborador obtenerColaboradorPorId(Integer id);
    void actualizarColaborador(Colaborador colaborador);
}
