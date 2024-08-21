package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.DireccionDespacho;
import com.zapatillas.proyecto.model.dto.DireccionDespachoDto;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IDireccionDespachoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/direccionDespacho")
public class DireccionDespachoController {

    private final IDireccionDespachoService direccionDespachoService;

    @GetMapping("/registro")
    public String frmDireccionDespacho(Model model) {
        model.addAttribute("listarDirecciones", direccionDespachoService.listarDireccionesDespacho());
        return "direccionDespacho/frmdirecciondespacho"; // Cambia esto según la vista que uses
    }

    // Create
    @PostMapping("/create")
    @ResponseBody
    public DireccionDespacho crearDireccionDespacho(@RequestBody DireccionDespachoDto direccionDespachoDto) {
        return direccionDespachoService.guardarDireccionDespacho(direccionDespachoDto);
    }

    // Read by ID
    @GetMapping("/{id}")
    @ResponseBody
    public DireccionDespacho obtenerDireccionDespachoPorId(@PathVariable("id") Integer id) {
        return direccionDespachoService.obtenerDireccionDespachoPorId(id);
    }

    // Update
    @PutMapping("/{id}")
    @ResponseBody
    public DireccionDespacho actualizarDireccionDespacho(@PathVariable("id") Integer id, @RequestBody DireccionDespachoDto direccionDespachoDto) {
        direccionDespachoDto.setIddirecciondespacho(id); // Set the ID in the DTO
        return direccionDespachoService.actualizarDireccionDespacho(direccionDespachoDto);
    }

    // Delete
    @DeleteMapping("/{id}")
    @ResponseBody
    public RespuestaGeneral eliminarDireccionDespacho(@PathVariable("id") Integer id) {
        String mensaje = "Dirección de Despacho eliminada exitosamente";
        boolean resultado = true;
        try {
            direccionDespachoService.eliminarDireccionDespachoPorId(id);
        } catch (Exception ex) {
            mensaje = "Error al conectar con la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    // List all
    @GetMapping("/listar")
    @ResponseBody
    public List<DireccionDespacho> listarDireccionesDespacho() {
        return direccionDespachoService.listarDireccionesDespacho();
    }
}
