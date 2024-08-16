package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.MetodoDePago;
import com.zapatillas.proyecto.repository.MetodoDePagoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MetodoDePagoService implements IMetodoDePagoService{
    private MetodoDePagoRepository metodoDePagoRepository;
    @Override
    public MetodoDePago obtenerMetodoPorNombre(String metodo) {
        return metodoDePagoRepository.findByMetodopago(metodo);
    }

    @Override
    public MetodoDePago guardarMetodo(MetodoDePago metodoDePago) {
        return metodoDePagoRepository.save(metodoDePago);
    }

    @Override
    public List<MetodoDePago> listarMetodosPago() {
        return metodoDePagoRepository.findAll();
    }

    @Override
    public MetodoDePago obtenerMetodoPorId(Integer id) {
        return metodoDePagoRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarMetodoPago(MetodoDePago metodoDePago) {

    }
}
