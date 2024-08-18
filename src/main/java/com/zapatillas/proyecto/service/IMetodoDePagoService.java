package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.MetodoDePago;

import java.util.List;

public interface IMetodoDePagoService {
    MetodoDePago obtenerMetodoPorNombre (String metodo);
    void guardarMetodo(MetodoDePago metodoDePago);
    List<MetodoDePago> listarMetodosPago();
    MetodoDePago obtenerMetodoPorId(Integer id);
    void actualizarMetodoPago(MetodoDePago metodoDePago);
    void eliminarMetodoPago(Integer id);
}
