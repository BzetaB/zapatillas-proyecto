package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EntradaDetalles;
import com.zapatillas.proyecto.repository.EntradaDetallesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EntradaDetallesService implements IEntradaDetallesService {

    private final EntradaDetallesRepository entradaDetalleRepository;

    @Override
    public List<EntradaDetalles> listarEntradaDetalles() {
        return entradaDetalleRepository.findAll();
    }

    @Override
    public EntradaDetalles guardarEntradaDetalle(EntradaDetalles entradaDetalle) {
        return entradaDetalleRepository.save(entradaDetalle);
    }

    @Override
    public EntradaDetalles buscarEntradaDetallePorId(Integer id) {
        return entradaDetalleRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEntradaDetalle(Integer id) {
        if (entradaDetalleRepository.existsById(id)) {
            entradaDetalleRepository.deleteById(id);
        } else {
            throw new RuntimeException("EntradaDetalle con ID " + id + " no encontrado");
        }
    }
}

