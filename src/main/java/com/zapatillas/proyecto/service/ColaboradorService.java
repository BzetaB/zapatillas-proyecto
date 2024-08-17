package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.model.bd.Rol;
import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import com.zapatillas.proyecto.model.dto.ColaboradorDto;
import com.zapatillas.proyecto.repository.ColaboradorRepository;
import com.zapatillas.proyecto.repository.RolRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


@AllArgsConstructor
@Service
public class ColaboradorService implements IColaboradorService {
    private ColaboradorRepository colaboradorRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public Colaborador obtenerColaboradorPorUsername(String username) {
        return colaboradorRepository.findByUsername(username);
    }

    @Override
    public Colaborador guardarColaborador(ColaboradorDto colaboradorDto) {
        Colaborador colaborador = new Colaborador();
        colaborador.setUsername(colaboradorDto.getUsername());
        colaborador.setPassword(bCryptPasswordEncoder.encode(colaboradorDto.getPassword()));
        colaborador.setNombres(colaboradorDto.getNombres());
        colaborador.setApellidos(colaboradorDto.getApellidos());
        colaborador.setFechaingreso(colaboradorDto.getFechaingreso());
        colaborador.setActivo(colaboradorDto.getActivo());

        Rol roles = rolRepository.findByNombrerol("USER");
        TipoDocumentoColaborador tipoDocumentoColaborador = new TipoDocumentoColaborador();
        colaborador.setRoles(new HashSet<>(Arrays.asList(roles)));
        tipoDocumentoColaborador.setIddocumento(colaboradorDto.getIddocumento());
        tipoDocumentoColaborador.setNombredocumento(colaboradorDto.getNombredocumento());
        colaborador.setTipoDocumentoColaborador(tipoDocumentoColaborador);

        return colaboradorRepository.save(colaborador);
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
