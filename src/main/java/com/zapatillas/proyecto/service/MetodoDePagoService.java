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
    public void guardarMetodo(MetodoDePago metodoDePago) {
         metodoDePagoRepository.save(metodoDePago);
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
        MetodoDePago updateMetodo = this.obtenerMetodoPorId(metodoDePago.getIdmetododepago());
        updateMetodo.setMetodopago(metodoDePago.getMetodopago());
        metodoDePagoRepository.save(updateMetodo);
    }

    @Override
    public void eliminarMetodoPago(Integer id) {
        metodoDePagoRepository.deleteById(id);
    }
}
