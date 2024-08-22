package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Categoria;

import java.util.List;

public interface ICategoriaService {
    Categoria obtenerCategoriaPorCatename(String catename);
    List<Categoria> listarCategorias();
    Categoria guardarCategoria(Categoria categoria);
    Categoria obtenerCategoriaPorId(Integer idcategoria);
    Categoria actualizarCategoria(Categoria categoria);
    void eliminarCategoria(Integer id);
}

