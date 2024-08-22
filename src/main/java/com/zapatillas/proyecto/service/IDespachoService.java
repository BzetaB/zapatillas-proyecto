package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Despacho;
import com.zapatillas.proyecto.model.dto.DespachoDto;

import java.util.Date;
import java.util.List;

public interface IDespachoService {
    Despacho guardarDespacho(DespachoDto despachoDto);
    Despacho actualizarDespacho(DespachoDto despachoDto);
    void eliminarDespachoPorId(Integer id);
    List<Despacho> listarDespachos();
    Despacho obtenerDespachoPorId(Integer id);
    List<Despacho> obtenerDespachosPorEstado(String estado);
    List<Despacho> obtenerDespachosPorFecha(Date fecha);
}
