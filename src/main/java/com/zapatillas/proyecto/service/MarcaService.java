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
    public Marca obtenerMarcaPorMarcaname(String marcaname) {

        return marcaRepository.findByMarcaname(marcaname);
    }

    @Override
    public List<Marca> listarMarcas() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca guardarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public Marca obtenerMarcaPorId(Integer idmarca) {
        return marcaRepository.findById(idmarca).orElse(null);
    }

    @Override
    public Marca actualizarMarca(Marca marca){
        Marca updateMarca = this.obtenerMarcaPorId(marca.getIdmarca());
        updateMarca.setMarcaname(marca.getMarcaname());
        return marcaRepository.save(updateMarca);
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


