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
    public void guardarRol(Rol rol) {
        rolRepository.save(rol);
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
        Rol updateRol = this.obtenerRolPorId(rol.getIdrol());
        updateRol.setNombrerol(rol.getNombrerol());
        rolRepository.save(updateRol);
    }

    @Override
    public void eliminarRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
