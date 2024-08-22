package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EntradaDetalles;

import java.util.List;

public interface IEntradaDetallesService {
    List<EntradaDetalles> listarEntradaDetalles();
    EntradaDetalles guardarEntradaDetalle(EntradaDetalles entradaDetalle);
    EntradaDetalles buscarEntradaDetallePorId(Integer id);
    void eliminarEntradaDetalle(Integer id);
}


