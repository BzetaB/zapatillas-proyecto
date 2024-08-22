package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Marca;
import com.zapatillas.proyecto.service.IMarcaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/marcas")
public class MarcaController {

    private IMarcaService marcaService;

    @GetMapping("/list")
    public String listarMarcas(Model model) {
        List<Marca> lista = marcaService.listarMarcas();
        model.addAttribute("marcas", lista);
        return "marca/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        Marca marca = id != null ? marcaService.buscarMarcaPorId(id) : new Marca();
        model.addAttribute("marca", marca);
        return "marca/form";
    }

    @PostMapping("/save")
    public String guardarMarca(@ModelAttribute Marca marca) {
        marcaService.guardarMarca(marca);
        return "redirect:/marcas/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarMarca(@PathVariable Integer id) {
        marcaService.eliminarMarca(id);
        return "redirect:/marcas/list";
    }
}

