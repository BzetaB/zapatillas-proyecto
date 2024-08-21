package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.EntradaProducto;
import com.zapatillas.proyecto.service.IEntradaProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/entrada-productos")
public class EntradaProductoController {

    private final IEntradaProductoService entradaProductoService;

    @GetMapping("/list")
    public String listarEntradaProductos(Model model) {
        List<EntradaProducto> lista = entradaProductoService.listarEntradaProductos();
        model.addAttribute("entradaProductos", lista);
        return "entrada-producto/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        EntradaProducto entradaProducto = id != null ? entradaProductoService.buscarEntradaProductoPorId(id) : new EntradaProducto();
        model.addAttribute("entradaProducto", entradaProducto);
        return "entrada-producto/form";
    }

    @PostMapping("/save")
    public String guardarEntradaProducto(@ModelAttribute EntradaProducto entradaProducto) {
        entradaProductoService.guardarEntradaProducto(entradaProducto);
        return "redirect:/entrada-productos/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarEntradaProducto(@PathVariable Integer id) {
        entradaProductoService.eliminarEntradaProducto(id);
        return "redirect:/entrada-productos/list";
    }
}


