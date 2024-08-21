package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Provedor;
import com.zapatillas.proyecto.service.IProvedorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/provedores")
public class ProvedorController {

    private final IProvedorService provedorService;

    @GetMapping("/list")
    public String listarProvedores(Model model) {
        List<Provedor> lista = provedorService.listarProvedores();
        model.addAttribute("provedores", lista);
        return "provedor/list";
    }

    @GetMapping("/form")
    public String mostrarFormulario(@RequestParam(required = false) Integer id, Model model) {
        Provedor provedor = id != null ? provedorService.buscarProvedorPorId(id) : new Provedor();
        model.addAttribute("provedor", provedor);
        return "provedor/form";
    }

    @PostMapping("/save")
    public String guardarProvedor(@ModelAttribute Provedor provedor) {
        provedorService.guardarProvedor(provedor);
        return "redirect:/provedores/list";
    }

    @GetMapping("/delete/{id}")
    public String eliminarProvedor(@PathVariable Integer id) {
        provedorService.eliminarProvedor(id);
        return "redirect:/provedores/list";
    }
}

