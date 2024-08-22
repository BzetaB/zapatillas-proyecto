package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EntradaProducto;
import com.zapatillas.proyecto.repository.EntradaProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EntradaProductoService implements IEntradaProductoService {

    private final EntradaProductoRepository entradaProductoRepository;

    @Override
    public List<EntradaProducto> listarEntradaProductos() {
        return entradaProductoRepository.findAll();
    }

    @Override
    public EntradaProducto guardarEntradaProducto(EntradaProducto entradaProducto) {
        return entradaProductoRepository.save(entradaProducto);
    }

    @Override
    public EntradaProducto buscarEntradaProductoPorId(Integer id) {
        return entradaProductoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarEntradaProducto(Integer id) {
        if (entradaProductoRepository.existsById(id)) {
            entradaProductoRepository.deleteById(id);
        } else {
            throw new RuntimeException("EntradaProducto con ID " + id + " no encontrado");
        }
    }
}




