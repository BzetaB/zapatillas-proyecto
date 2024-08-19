package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EstadoVenta;
import com.zapatillas.proyecto.repository.EstadoVentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EstadoVentaService implements IEstadoVentaService{
    private EstadoVentaRepository estadoVentaRepository;
    @Override
    public EstadoVenta obtenerEstadoPorId(Integer id) {
        return estadoVentaRepository.findById(id).orElse(null);
    }

    @Override
    public EstadoVenta obtenerEstadoPorNombre(String estado) {
        return estadoVentaRepository.findByEstado(estado);
    }

    @Override
    public List<EstadoVenta> listarEstadosVenta() {
        return estadoVentaRepository.findAll();
    }

    @Override
    public EstadoVenta guardarEstado(EstadoVenta estadoVenta) {
        return estadoVentaRepository.save(estadoVenta);
    }

    @Override
    public EstadoVenta actualizarEstado(EstadoVenta estadoVenta) {
       EstadoVenta updateEstado = this.obtenerEstadoPorId(estadoVenta.getIdestadoventa());
       updateEstado.setEstado(estadoVenta.getEstado());
       return estadoVentaRepository.save(updateEstado);
    }

    @Override
    public void eliminarEstado(Integer id) {
        estadoVentaRepository.deleteById(id);
    }
}
