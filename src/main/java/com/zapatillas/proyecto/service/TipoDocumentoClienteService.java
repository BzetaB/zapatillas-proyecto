package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.TipoDocumentoCliente;
import com.zapatillas.proyecto.repository.TipoDocumentoClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TipoDocumentoClienteService implements iTipoDocumentoClienteService {
    private TipoDocumentoClienteRepository tipoDocumentoClienteRepository;

    @Override
    public TipoDocumentoCliente obtenerTipoDocumentoClientePorDescripcion(String descripcion) {
        return tipoDocumentoClienteRepository.findByDescripciondocumento(descripcion);
    }

    @Override
    public TipoDocumentoCliente guardarTipoDocumentoCliente(TipoDocumentoCliente tipoDocumentoCliente) {
        return tipoDocumentoClienteRepository.save(tipoDocumentoCliente);
    }

    @Override
    public List<TipoDocumentoCliente> listarTiposDocumentoCliente() {
        return tipoDocumentoClienteRepository.findAll();
    }

    @Override
    public TipoDocumentoCliente obtenerTipoDocumentoClientePorId(Integer id) {
        return tipoDocumentoClienteRepository.findById(id).orElse(null);
    }

    @Override
    public TipoDocumentoCliente actualizarTipoDocumentoCliente(TipoDocumentoCliente tipoDocumentoCliente) {
        TipoDocumentoCliente updateTipoDocCliente = this.obtenerTipoDocumentoClientePorId(
                tipoDocumentoCliente.getIdtipodocumento());
        updateTipoDocCliente.setDescripciondocumento(tipoDocumentoCliente.getDescripciondocumento());
        return tipoDocumentoClienteRepository.save(updateTipoDocCliente);
    }

    @Override
    public void eliminarTipoDocumentoCliente(Integer id) {
        tipoDocumentoClienteRepository.deleteById(id);
    }
}