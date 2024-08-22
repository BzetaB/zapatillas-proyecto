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
public class EntradaDetallesController {

    private IEntradaDetallesService entradaDetallesService;

    @GetMapping("/list")
    public String listarEntradaDetalles(Model model) {
        List<EntradaDetalles> lista = entradaDetallesService.listarEntradaDetalles();
        model.addAttribute("entradaDetalles", lista);
        return "entrada-detalle/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        EntradaDetalles entradaDetalle = id != null ? entradaDetallesService.buscarEntradaDetallePorId(id) : new EntradaDetalles();
        model.addAttribute("entradaDetalle", entradaDetalle);
        return "entrada-detalle/form";
    }

    @PostMapping("/save")
    public String guardarEntradaDetalle(@ModelAttribute EntradaDetalles entradaDetalle) {
        entradaDetallesService.guardarEntradaDetalle(entradaDetalle);
        return "redirect:/entrada-detalles/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEntradaDetalle(@PathVariable Integer id) {
        entradaDetallesService.eliminarEntradaDetalle(id);
        return "redirect:/entrada-detalles/list";
    }
}

