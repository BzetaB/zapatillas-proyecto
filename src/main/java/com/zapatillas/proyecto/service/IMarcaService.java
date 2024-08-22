package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Marca;

import java.util.List;

public interface IMarcaService {
    List<Marca> listarMarcas();
    Marca guardarMarca(Marca marca);
    Marca buscarMarcaPorId(Integer id);
    void eliminarMarca(Integer id);
}


