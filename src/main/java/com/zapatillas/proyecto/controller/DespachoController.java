package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Despacho;
import com.zapatillas.proyecto.model.dto.DespachoDto;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IDespachoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/despacho")
public class DespachoController {

    private final IDespachoService despachoService;

    @GetMapping("/registro")
    public String frmDespacho(Model model) {
        model.addAttribute("listarDespachos", despachoService.listarDespachos());
        return "despacho/frmdespacho"; // Cambia esto según la vista que uses
    }

    // Create
    @PostMapping("/create")
    @ResponseBody
    public Despacho crearDespacho(@RequestBody DespachoDto despachoDto) {
        return despachoService.guardarDespacho(despachoDto);
    }

    // Read by ID
    @GetMapping("/{id}")
    @ResponseBody
    public Despacho obtenerDespachoPorId(@PathVariable("id") Integer id) {
        return despachoService.obtenerDespachoPorId(id);
    }

    // Update
    @PutMapping("/{id}")
    @ResponseBody
    public Despacho actualizarDespacho(@PathVariable("id") Integer id, @RequestBody DespachoDto despachoDto) {
        despachoDto.setIddespacho(id); // Set the ID in the DTO
        return despachoService.actualizarDespacho(despachoDto);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseBody
    public RespuestaGeneral eliminarDespacho(@PathVariable("id") Integer id) {
        String mensaje = "Despacho eliminado exitosamente";
        boolean resultado = true;
        try {
            despachoService.eliminarDespachoPorId(id);
        } catch (Exception ex) {
            mensaje = "Error al conectar con la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    // List by Estado
    @GetMapping("/estado/{estado}")
    @ResponseBody
    public List<Despacho> obtenerDespachosPorEstado(@PathVariable("estado") String estado) {
        return despachoService.obtenerDespachosPorEstado(estado);
    }

    // List by Fecha
    @GetMapping("/fecha/{fecha}")
    @ResponseBody
    public List<Despacho> obtenerDespachosPorFecha(@PathVariable("fecha") Date fecha) {
        return despachoService.obtenerDespachosPorFecha(fecha);
    }
}
