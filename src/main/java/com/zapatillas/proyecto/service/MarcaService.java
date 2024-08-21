package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Marca;
import com.zapatillas.proyecto.repository.MarcaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MarcaService implements IMarcaService {

    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca guardarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca buscarMarcaPorId(Integer id) {
        return marcaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarMarca(Integer id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Marca con ID " + id + " no encontrada");
        }
    }
}


