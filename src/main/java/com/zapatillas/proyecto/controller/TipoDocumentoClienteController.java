package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.TipoDocumentoCliente;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tipodocumentocliente")
public class TipoDocumentoClienteController {

    private final com.zapatillas.proyecto.service.iTipoDocumentoClienteService iTipoDocumentoClienteService;

    @GetMapping("/registro")
    public String frmTipoDocumentoCliente(Model model){
        model.addAttribute(
                "listarTipoDocClientes",
                iTipoDocumentoClienteService.listarTiposDocumentoCliente());
        return "cliente/frmtipodocumentocliente";
    }

    // Create
    @PostMapping("/create")
    @ResponseBody
    public TipoDocumentoCliente createTipoDocumentoCliente(@RequestBody TipoDocumentoCliente tipoDocumentoCliente){
        return iTipoDocumentoClienteService.guardarTipoDocumentoCliente(tipoDocumentoCliente);
    }

    // Read
    @GetMapping("/listar")
    @ResponseBody
    public List<TipoDocumentoCliente> tipoDocumentoClienteList(){
        return iTipoDocumentoClienteService.listarTiposDocumentoCliente();
    }

    // Update
    @PutMapping("/{id}")
    @ResponseBody
    public TipoDocumentoCliente updateTipoDocumentoCliente(@PathVariable("id") Integer id,
                                                           @RequestBody TipoDocumentoCliente tipoDocumentoCliente){
        tipoDocumentoCliente.setIdtipodocumento(id); // Ensure the ID is set for the update
        return iTipoDocumentoClienteService.actualizarTipoDocumentoCliente(tipoDocumentoCliente);
    }

    // Delete
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral deleteTipoDocumentoCliente(@PathVariable("id") Integer id){
        String mensaje = "Tipo de Documento de Cliente eliminado exitosamente";
        boolean resultado = true;
        try {
            iTipoDocumentoClienteService.eliminarTipoDocumentoCliente(id);
        } catch (Exception ex) {
            mensaje = "Error al conectar con la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public TipoDocumentoCliente obtenerTipoDocumentoCliente(@PathVariable("id") Integer id){
        return iTipoDocumentoClienteService.obtenerTipoDocumentoClientePorId(id);
    }
}
