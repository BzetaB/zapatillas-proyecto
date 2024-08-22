package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Cliente;
import com.zapatillas.proyecto.model.dto.ClienteDto;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    private IClienteService iClienteService;

    @GetMapping("/registro")
    public String frmCliente(Model model) {
        model.addAttribute("listaclientes", iClienteService.listarClientes());
        return "cliente/frmcliente";
    }

    // Create
    @PostMapping("/registrar")
    @ResponseBody
    public Cliente guardarCliente(@RequestBody ClienteDto clienteDto) {
        return iClienteService.guardarCliente(clienteDto);
    }

    // Read
    @GetMapping("/listar")
    @ResponseBody
    public List<Cliente> listarClientes() {
        return iClienteService.listarClientes();
    }

    // Update
    @PutMapping("/{id}")
    @ResponseBody
    public Cliente actualizarCliente(@PathVariable("id") Integer id,
                                     @RequestBody ClienteDto clienteDto) {
        return iClienteService.actualizarCliente(clienteDto);
    }

    // Delete
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral eliminarCliente(@PathVariable("id") Integer id) {
        String mensaje = "Cliente eliminado correctamente";
        boolean resultado = true;
        try {
            iClienteService.eliminarClientePorId(id);
        } catch (Exception ex) {
            mensaje = "Error: Ocurrió un error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    // Obtener Cliente por ID
    @GetMapping("/{id}")
    @ResponseBody
    public Cliente obtenerCliente(@PathVariable("id") Integer id) {
        return iClienteService.obtenerClientePorId(id);
    }

    // Obtener Cliente por Username
    @GetMapping("/username/{username}")
    @ResponseBody
    public Cliente obtenerClientePorUsername(@PathVariable("username") String username) {
        return iClienteService.obtenerClientePorUsername(username);
    }
}
