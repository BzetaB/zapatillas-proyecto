package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import com.zapatillas.proyecto.model.dto.ColaboradorDto;
import com.zapatillas.proyecto.repository.ColaboradorRepository;
import com.zapatillas.proyecto.repository.TipoDocumentoColaboradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class ColaboradorService implements IColaboradorService {
    private ColaboradorRepository colaboradorRepository;
    private TipoDocumentoColaboradorRepository tipoDocumentoColaboradorRepository;
    @Override
    public Colaborador obtenerColaboradorPorUsername(String username) {
        return colaboradorRepository.findByUsername(username);
    }

    @Override
    public void guardarColaborador(ColaboradorDto colaboradorDto) {
        if (colaboradorDto.getIdcolaborador() != null && colaboradorDto.getIdcolaborador() > 0) {
            // Actualiza el colaborador existente
            colaboradorRepository.actualizarColaborador(
                    colaboradorDto.getNombres(),
                    colaboradorDto.getApellidos(),
                    colaboradorDto.getActivo(),
                    colaboradorDto.getIdcolaborador()
            );
        } else {
            Colaborador nuevoColaborador = new Colaborador();
            nuevoColaborador.setUsername(colaboradorDto.getUsername());
            nuevoColaborador.setPassword(colaboradorDto.getPassword());
            nuevoColaborador.setNombres(colaboradorDto.getNombres());
            nuevoColaborador.setApellidos(colaboradorDto.getApellidos());
            nuevoColaborador.setCorreo(colaboradorDto.getCorreo());
            nuevoColaborador.setFechaingreso(colaboradorDto.getFechaingreso());
            nuevoColaborador.setActivo(colaboradorDto.getActivo());

            TipoDocumentoColaborador tipoDocumentoColaborador = new TipoDocumentoColaborador();
            tipoDocumentoColaborador.setIddocumento(colaboradorDto.getIddocumento());
            nuevoColaborador.setTipoDocumentoColaborador(tipoDocumentoColaborador);

            colaboradorRepository.save(nuevoColaborador);
        }
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