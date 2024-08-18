package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Venta;
import com.zapatillas.proyecto.model.dto.VentaDto;

import java.util.List;

public interface IVentaService {
    Venta obtenerVentaPorId(Integer id);
    void guardarVenta(VentaDto ventaDto);
    List<Venta> listarVenta();
    void actualizarVenta(VentaDto ventaDto);
    void eliminarVenta(Integer id);
}
