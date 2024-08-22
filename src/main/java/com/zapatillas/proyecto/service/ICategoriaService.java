package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> listarCategorias();
    Categoria guardarCategoria(Categoria categoria);
    Categoria buscarCategoriaPorId(Integer id);
    void eliminarCategoria(Integer id);
}

