package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Marca;
import com.zapatillas.proyecto.model.bd.Rol;

import java.util.List;

public interface IMarcaService {
    Marca obtenerMarcaPorMarcaname(String marcaname);
    Marca guardarMarca(Marca marca);
    List<Marca> listarMarcas();
    Marca obtenerMarcaPorId(Integer idmarca);
    Marca actualizarMarca(Marca marca);
    void eliminarMarca(Integer id);
}


