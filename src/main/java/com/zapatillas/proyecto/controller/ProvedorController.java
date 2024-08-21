package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Provedor;
import com.zapatillas.proyecto.service.IProvedorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/provedores")
public class ProvedorController {

    private IProvedorService provedorService;

    @GetMapping
    public List<Provedor> getAllProvedores() {
        return provedorService.listarProvedores();
    }

    @GetMapping("/{id}")
    public Optional<Provedor> getProvedorById(@PathVariable Integer id) {
        return Optional.ofNullable(provedorService.buscarProvedorPorId(id));
    }

    @PostMapping
    public Provedor createProvedor(@RequestBody Provedor provedor) {
        return provedorService.guardarProvedor(provedor);
    }

    @PutMapping("/{id}")
    public Provedor updateProvedor(@PathVariable Integer id, @RequestBody Provedor provedor) {
        if (provedorService.buscarProvedorPorId(id) != null) {
            provedor.setIdprovedor(id);
            return provedorService.guardarProvedor(provedor);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProvedor(@PathVariable Integer id) {
        if (provedorService.buscarProvedorPorId(id) != null) {
            provedorService.eliminarProvedor(id);
        }
    }
}
