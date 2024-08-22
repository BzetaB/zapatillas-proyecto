package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Producto;
import com.zapatillas.proyecto.model.dto.ProductoDto;

import java.util.List;

public interface IProductoService {
    List<Producto> listarProductos();
    Producto guardarProducto(ProductoDto productoDto);
    Producto actualizarProducto(ProductoDto productoDto);
    Producto buscarProductoPorId(Integer id);
    void eliminarProducto(Integer id);
}

