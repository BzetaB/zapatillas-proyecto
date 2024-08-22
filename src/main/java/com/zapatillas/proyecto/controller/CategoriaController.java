package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Categoria;
import com.zapatillas.proyecto.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private ICategoriaService categoriaService;

    @GetMapping("/list")
    public String listarCategorias(Model model) {
        List<Categoria> lista = categoriaService.listarCategorias();
        model.addAttribute("categorias", lista);
        return "categoria/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        Categoria categoria = id != null ? categoriaService.buscarCategoriaPorId(id) : new Categoria();
        model.addAttribute("categoria", categoria);
        return "categoria/form";
    }

    @PostMapping("/save")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminarCategoria(id);
        return "redirect:/categorias/list";
    }
}

