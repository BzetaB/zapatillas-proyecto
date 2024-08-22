package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EntradaDetalles;
import com.zapatillas.proyecto.repository.EntradaDetallesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EntradaDetallesService implements IEntradaDetallesService {

    private EntradaDetallesRepository entradaDetallesRepository;

    @Override
    public List<EntradaDetalles> listarEntradaDetalles() {
        return entradaDetallesRepository.findAll();
    }

    @Override
    public EntradaDetalles guardarEntradaDetalle(EntradaDetalles entradaDetalle) {
        return entradaDetallesRepository.save(entradaDetalle);
    }

    @Override
    public EntradaDetalles buscarEntradaDetallePorId(Integer id) {
        return entradaDetallesRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEntradaDetalle(Integer id) {
        if (entradaDetallesRepository.existsById(id)) {
            entradaDetallesRepository.deleteById(id);
        } else {
            throw new RuntimeException("EntradaDetalle con ID " + id + " no encontrado");
        }
    }
}


