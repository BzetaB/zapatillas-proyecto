package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Venta;
import com.zapatillas.proyecto.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VentaService implements IVentaService{
    private VentaRepository ventaRepository;
    @Override
    public Venta obtenerVentaPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta guardarVenta(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> listarVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public void actualizarVenta(Venta venta) {

    }
}
