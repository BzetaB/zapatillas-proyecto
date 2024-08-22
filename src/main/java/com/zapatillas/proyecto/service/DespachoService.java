package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Despacho;
import com.zapatillas.proyecto.model.dto.DespachoDto;
import com.zapatillas.proyecto.repository.DespachoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class DespachoService implements IDespachoService {
    private final DespachoRepository despachoRepository;

    @Override
    public Despacho guardarDespacho(DespachoDto despachoDto) {
        Despacho nuevoDespacho = new Despacho();
        nuevoDespacho.setFechadespacho(despachoDto.getFechadespacho());
        nuevoDespacho.setEstadodespacho(despachoDto.getEstadodespacho());
        nuevoDespacho.setCliente(despachoDto.getCliente()); // Establece el cliente del DTO
        nuevoDespacho.setDireccionDespacho(despachoDto.getDireccionDespacho()); // Establece la dirección del DTO
        return despachoRepository.save(nuevoDespacho);
    }

    @Override
    public Despacho actualizarDespacho(DespachoDto despachoDto) {
        Despacho despachoExistente = despachoRepository.findById(despachoDto.getIddespacho()).orElse(null);
        if (despachoExistente != null) {
            despachoExistente.setFechadespacho(despachoDto.getFechadespacho());
            despachoExistente.setEstadodespacho(despachoDto.getEstadodespacho());
            despachoExistente.setCliente(despachoDto.getCliente()); // Actualiza el cliente del DTO
            despachoExistente.setDireccionDespacho(despachoDto.getDireccionDespacho()); // Actualiza la dirección del DTO
            return despachoRepository.save(despachoExistente);
        }
        return null;
    }

    @Override
    public void eliminarDespachoPorId(Integer id) {
        despachoRepository.deleteById(id);
    }

    @Override
    public List<Despacho> listarDespachos() {
        return despachoRepository.findAll();
    }

    @Override
    public Despacho obtenerDespachoPorId(Integer id) {
        return despachoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Despacho> obtenerDespachosPorEstado(String estado) {
        return despachoRepository.findByEstadodespacho(estado);
    }

    @Override
    public List<Despacho> obtenerDespachosPorFecha(Date fecha) {
        return despachoRepository.findByFechadespacho(fecha);
    }
}
