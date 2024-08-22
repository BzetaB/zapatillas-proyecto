package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Producto;
import com.zapatillas.proyecto.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/productos")
public class ProductoController {

    private IProductoService productoService;

    @GetMapping("/list")
    public String listarProductos(Model model) {
        List<Producto> lista = productoService.listarProductos();
        model.addAttribute("productos", lista);
        return "producto/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        Producto producto = id != null ? productoService.buscarProductoPorId(id) : new Producto();
        model.addAttribute("producto", producto);
        return "producto/form";
    }

    @PostMapping("/save")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos/list";
    }
}

