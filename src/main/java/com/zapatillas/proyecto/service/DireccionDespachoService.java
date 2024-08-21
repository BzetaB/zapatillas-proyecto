package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.DireccionDespacho;
import com.zapatillas.proyecto.model.dto.DireccionDespachoDto;
import com.zapatillas.proyecto.repository.DireccionDespachoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DireccionDespachoService implements IDireccionDespachoService {
    private final DireccionDespachoRepository direccionDespachoRepository;

    @Override
    public DireccionDespacho obtenerDireccionDespachoPorId(Integer id) {
        return direccionDespachoRepository.findById(id).orElse(null);
    }

    @Override
    public DireccionDespacho guardarDireccionDespacho(DireccionDespachoDto direccionDespachoDto) {
        DireccionDespacho nuevaDireccion = new DireccionDespacho();
        nuevaDireccion.setDireccion(direccionDespachoDto.getDireccion());
        nuevaDireccion.setCiudad(direccionDespachoDto.getCiudad());
        nuevaDireccion.setCodigopostal(direccionDespachoDto.getCodigopostal());
        return direccionDespachoRepository.save(nuevaDireccion);
    }

    @Override
    public DireccionDespacho actualizarDireccionDespacho(DireccionDespachoDto direccionDespachoDto) {
        DireccionDespacho direccionExistente = obtenerDireccionDespachoPorId(direccionDespachoDto.getIddirecciondespacho());
        if (direccionExistente != null) {
            direccionExistente.setDireccion(direccionDespachoDto.getDireccion());
            direccionExistente.setCiudad(direccionDespachoDto.getCiudad());
            direccionExistente.setCodigopostal(direccionDespachoDto.getCodigopostal());
            return direccionDespachoRepository.save(direccionExistente);
        }
        return null;
    }

    @Override
    public void eliminarDireccionDespachoPorId(Integer id) {
        direccionDespachoRepository.deleteById(id);
    }

    @Override
    public List<DireccionDespacho> listarDireccionesDespacho() {
        return direccionDespachoRepository.findAll();
    }
}
