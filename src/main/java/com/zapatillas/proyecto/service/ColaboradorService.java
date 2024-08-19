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
    public Colaborador guardarColaborador(ColaboradorDto colaboradorDto) {

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

            return colaboradorRepository.save(nuevoColaborador);
    }

    @Override
    public Colaborador actualizarColab(ColaboradorDto colaboradorDto) {

        Colaborador updateColaborador = colaboradorRepository.findById(
                colaboradorDto.getIdcolaborador()).orElse(null);
            updateColaborador.setUsername(colaboradorDto.getUsername());
            updateColaborador.setPassword(colaboradorDto.getPassword());
            updateColaborador.setNombres(colaboradorDto.getNombres());
            updateColaborador.setApellidos(colaboradorDto.getApellidos());
            updateColaborador.setFechaingreso(colaboradorDto.getFechaingreso());
            updateColaborador.setActivo(colaboradorDto.getActivo());

            if (colaboradorDto.getIddocumento() != null) {
                // Cargar el TipoDocumentoColaborador existente desde la base de datos
                TipoDocumentoColaborador tipoDocumentoColaborador = tipoDocumentoColaboradorRepository.findById(colaboradorDto.getIddocumento()).orElse(null);

                updateColaborador.setTipoDocumentoColaborador(tipoDocumentoColaborador);
            } else {
                // Manejar el caso en que iddocumento no se proporciona
                updateColaborador.setTipoDocumentoColaborador(null);
            }

            return colaboradorRepository.save(updateColaborador);
    }

    @Override
    public void eliminarColaboradorPorId(Integer id) {
        colaboradorRepository.deleteById(id);
    }

    @Override
    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Colaborador obtenerColaboradorPorId(Integer id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

}