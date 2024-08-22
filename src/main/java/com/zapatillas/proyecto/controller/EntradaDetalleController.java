package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.EntradaDetalles;
import com.zapatillas.proyecto.service.IEntradaDetallesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/entrada-detalles")
public class EntradaDetalleController {

    private IEntradaDetallesService entradaDetalleService;

    @GetMapping("/list")
    public String listarEntradaDetalles(Model model) {
        List<EntradaDetalles> lista = entradaDetalleService.listarEntradaDetalles();
        model.addAttribute("entradaDetalles", lista);
        return "entrada-detalle/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        EntradaDetalles entradaDetalle = id != null ? entradaDetalleService.buscarEntradaDetallePorId(id) : new EntradaDetalles();
        model.addAttribute("entradaDetalle", entradaDetalle);
        return "entrada-detalle/form";
    }

    @PostMapping("/save")
    public String guardarEntradaDetalle(@ModelAttribute EntradaDetalles entradaDetalle) {
        entradaDetalleService.guardarEntradaDetalle(entradaDetalle);
        return "redirect:/entrada-detalles/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEntradaDetalle(@PathVariable Integer id) {
        entradaDetalleService.eliminarEntradaDetalle(id);
        return "redirect:/entrada-detalles/list";
    }
}

