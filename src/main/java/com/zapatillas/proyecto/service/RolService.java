package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Rol;
import com.zapatillas.proyecto.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RolService implements IRolService{
    private RolRepository rolRepository;
    @Override
    public Rol obtenerRolPorMombrerol(String nombrerol) {
        return rolRepository.findByNombrerol(nombrerol);
    }

    @Override
    public Rol guardarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public List<Rol> listarRol() {
        return rolRepository.findAll();
    }

    @Override
    public Rol obtenerRolPorId(Integer idrol) {
        return rolRepository.findById(idrol).orElse(null);
    }

    @Override
    public void actualizarRol(Rol rol) {

    }
}
