package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EntradaProducto;

import java.util.List;

public interface IEntradaProductoService {
    List<EntradaProducto> listarEntradaProductos();
    EntradaProducto guardarEntradaProducto(EntradaProducto entradaProducto);
    EntradaProducto buscarEntradaProductoPorId(Integer id);
    void eliminarEntradaProducto(Integer id);
}


