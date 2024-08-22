package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProductos();
    Producto guardarProducto(Producto producto);
    Producto buscarProductoPorId(Integer id);
    void eliminarProducto(Integer id);
}

