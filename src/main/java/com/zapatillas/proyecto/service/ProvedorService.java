package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Provedor;
import com.zapatillas.proyecto.repository.ProvedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProvedorService implements IProvedorService {

    private ProvedorRepository provedorRepository;

    @Override
    public List<Provedor> listarProvedores() {
        return provedorRepository.findAll();
    }

    @Override
    public Provedor guardarProvedor(Provedor provedor) {
        return provedorRepository.save(provedor);
    }

    @Override
    public Provedor buscarProvedorPorId(Integer id) {
        return provedorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarProvedor(Integer id) {
        if (provedorRepository.existsById(id)) {
            provedorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Provedor con ID " + id + " no encontrado");
        }
    }
}


