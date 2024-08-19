package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;

import java.util.List;

public interface iTipoDocumentoColaboradorService {
    TipoDocumentoColaborador obtenerDocumentoColaboradorPorNombreDoc(String documento);
    TipoDocumentoColaborador guardarDocumentoColaborador(TipoDocumentoColaborador tipoDocumentoColaborador);
    List<TipoDocumentoColaborador> listarTiposDocColaborador();
    TipoDocumentoColaborador obtenerTipoDocColabPorId(Integer id);
    TipoDocumentoColaborador actualizarTipoDocumentoCola(TipoDocumentoColaborador tipoDocumentoColaborador);
    void eliminarTipoDocColab(Integer id);
}
