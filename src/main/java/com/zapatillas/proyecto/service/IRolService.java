package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Rol;

import java.util.List;

public interface IRolService {
    Rol obtenerRolPorMombrerol(String nombrerol);
    void guardarRol(Rol rol);
    List<Rol> listarRol();
    Rol obtenerRolPorId(Integer idrol);
    void actualizarRol(Rol rol);
    void eliminarRol(Integer id);
}
