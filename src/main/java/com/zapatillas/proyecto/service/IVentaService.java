package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Venta;

import java.util.List;

public interface IVentaService {
    Venta obtenerVentaPorId(Integer id);
    Venta guardarVenta(Venta venta);
    List<Venta> listarVenta();
    void actualizarVenta(Venta venta);
}
