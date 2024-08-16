package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.repository.ColaboradorRepository;
import com.zapatillas.proyecto.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ColaboradorService implements IColaboradorService {
    private ColaboradorRepository colaboradorRepository;
    private RolRepository rolRepository;
    @Override
    public Colaborador obtenerColaboradorPorUsername(String username) {
        return colaboradorRepository.findByUsername(username);
    }

    @Override
    public Colaborador guardarColaborador(Colaborador colaborador) {
        return null;
    }

    @Override
    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador obtenerColaboradorPorId(Integer id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarColaborador(Colaborador colaborador) {
        colaboradorRepository.actualizarColaborador(
                colaborador.getNombres(),
                colaborador.getApellidos(),
                colaborador.getActivo(),
                colaborador.getIdcolaborador()
        );

    }
}
