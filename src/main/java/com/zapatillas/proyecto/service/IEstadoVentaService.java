package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EstadoVenta;

import java.util.List;

public interface IEstadoVentaService {
    EstadoVenta obtenerEstadoPorId(Integer id);
    EstadoVenta obtenerEstadoPorNombre(String estado);
    List<EstadoVenta> listarEstadosVenta();
    EstadoVenta guardarEstado(EstadoVenta estadoVenta);
    void actualizarEstado(EstadoVenta estadoVenta);
}
