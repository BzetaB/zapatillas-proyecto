package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import com.zapatillas.proyecto.repository.TipoDocumentoColaboradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class TipoDocumentoColaboradorService implements iTipoDocumentoColaboradorService{
    private TipoDocumentoColaboradorRepository tipoDocumentoColaboradorRepository;
    @Override
    public TipoDocumentoColaborador obtenerDocumentoColaboradorPorNombreDoc(String documento) {
        return tipoDocumentoColaboradorRepository.findByNombredocumento(documento);
    }

    @Override
    public TipoDocumentoColaborador guardarDocumentoColaborador(TipoDocumentoColaborador tipoDocumentoColaborador) {
        return tipoDocumentoColaboradorRepository.save(tipoDocumentoColaborador);
    }

    @Override
    public List<TipoDocumentoColaborador> listarTiposDocColaborador() {
        return tipoDocumentoColaboradorRepository.findAll();
    }

    @Override
    public TipoDocumentoColaborador obtenerTipoDocColabPorId(Integer id) {
        return tipoDocumentoColaboradorRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarTipoDocumentoCola(TipoDocumentoColaborador tipoDocumentoColaborador) {

    }
}
