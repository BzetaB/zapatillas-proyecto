package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.TipoDocumentoCliente;

import java.util.List;

public interface iTipoDocumentoClienteService {
    TipoDocumentoCliente obtenerTipoDocumentoClientePorDescripcion(String descripcion);
    TipoDocumentoCliente guardarTipoDocumentoCliente(TipoDocumentoCliente tipoDocumentoCliente);
    List<TipoDocumentoCliente> listarTiposDocumentoCliente();
    TipoDocumentoCliente obtenerTipoDocumentoClientePorId(Integer id);
    TipoDocumentoCliente actualizarTipoDocumentoCliente(TipoDocumentoCliente tipoDocumentoCliente);
    void eliminarTipoDocumentoCliente(Integer id);
}
