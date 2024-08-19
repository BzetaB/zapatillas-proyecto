package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Rol;

import java.util.List;

public interface IRolService {
    Rol obtenerRolPorMombrerol(String nombrerol);
    Rol guardarRol(Rol rol);
    List<Rol> listarRol();
    Rol obtenerRolPorId(Integer idrol);
    Rol actualizarRol(Rol rol);
    void eliminarRol(Integer id);
}
