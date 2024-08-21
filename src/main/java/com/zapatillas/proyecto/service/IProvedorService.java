package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Provedor;

import java.util.List;

public interface IProvedorService {
    List<Provedor> listarProvedores();
    Provedor guardarProvedor(Provedor provedor);
    Provedor buscarProvedorPorId(Integer id);
    void eliminarProvedor(Integer id);
}


