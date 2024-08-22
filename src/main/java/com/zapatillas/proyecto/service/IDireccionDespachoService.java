package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.DireccionDespacho;
import com.zapatillas.proyecto.model.dto.DireccionDespachoDto;

import java.util.List;

public interface IDireccionDespachoService {
    DireccionDespacho obtenerDireccionDespachoPorId(Integer id);
    DireccionDespacho guardarDireccionDespacho(DireccionDespachoDto direccionDespachoDto);
    DireccionDespacho actualizarDireccionDespacho(DireccionDespachoDto direccionDespachoDto);
    void eliminarDireccionDespachoPorId(Integer id);
    List<DireccionDespacho> listarDireccionesDespacho();
}
