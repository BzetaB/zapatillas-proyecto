package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.EstadoVenta;
import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import com.zapatillas.proyecto.model.bd.Venta;
import com.zapatillas.proyecto.model.dto.VentaDto;
import com.zapatillas.proyecto.repository.EstadoVentaRepository;
import com.zapatillas.proyecto.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VentaService implements IVentaService{
    private VentaRepository ventaRepository;
    private EstadoVentaRepository estadoVentaRepository;
    @Override
    public Venta obtenerVentaPorId(Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarVenta(VentaDto ventaDto) {
        Venta nuevaVenta = new Venta();
        EstadoVenta estadoVenta = new EstadoVenta();
        estadoVenta.setIdestadoventa(ventaDto.getIdestadoventa());
        nuevaVenta.setEstadoVenta(estadoVenta);
        ventaRepository.save(nuevaVenta);
    }

    @Override
    public List<Venta> listarVenta() {
        return ventaRepository.findAll();
    }

    @Override
    public void actualizarVenta(VentaDto ventaDto) {

           Venta updateVenta = this.obtenerVentaPorId(ventaDto.getIdventa());

           if (ventaDto.getIdestadoventa() != null){
               EstadoVenta estadoVenta = estadoVentaRepository.findById(
                       ventaDto.getIdestadoventa()).orElse(null);

               updateVenta.setEstadoVenta(estadoVenta);
           }else {
               updateVenta.setEstadoVenta(null);
           }
           ventaRepository.save(updateVenta);
    }

    @Override
    public void eliminarVenta(Integer id) {
        ventaRepository.deleteById(id);
    }
}
