package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.TipoDocumentoColaborador;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.iTipoDocumentoColaboradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tipodocumentocolaborador")
public class TipoDocumentoColaboradorController {
    private iTipoDocumentoColaboradorService iTipoDocumentoColaboradorService;
    @GetMapping("/registro")
    public String frmTipoDocumentoColaborador(Model model){
        model.addAttribute(
                "listarTipoDocColaboradores",
                iTipoDocumentoColaboradorService.listarTiposDocColaborador());
        return "colaborador/frmtipodocumentocolaborador";
    }

    //create
    @PostMapping("/create")
    @ResponseBody
    public RespuestaGeneral createTipoDocumentoColaborador
    (@RequestBody TipoDocumentoColaborador tipoDocumentoColaborador){
        String mensaje = "Tipo de Documento de Colaborador creado exitosamente";
        boolean resultado = true;
        try {
            iTipoDocumentoColaboradorService.guardarDocumentoColaborador(tipoDocumentoColaborador);
        }catch (Exception ex){
            mensaje = "Error al conectar con la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }


    //read
    @GetMapping("/listar")
    @ResponseBody
    public List<TipoDocumentoColaborador> tipoDocumentoColaboradorList(){
        return iTipoDocumentoColaboradorService.listarTiposDocColaborador();
    }

    //update
    @PostMapping("/update")
    @ResponseBody
    public RespuestaGeneral updateDocumentoColaborador(@RequestBody TipoDocumentoColaborador tipoDocumentoColaborador){
        String mensaje = "Tipo de Documento de Colaborador actualizado exitosamente";
        boolean resultado = true;
        try {
            iTipoDocumentoColaboradorService.actualizarTipoDocumentoCola(tipoDocumentoColaborador);
        }catch (Exception ex){
            mensaje = "Error al conectar con la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //delete
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral updateDocumentoColaborador(@PathVariable("id") int id){
        String mensaje = "Tipo de Documento de Colaborador eliminado exitosamente";
        boolean resultado = true;
        try {
            iTipoDocumentoColaboradorService.eliminarTipoDocColab(id);
        }catch (Exception ex){
            mensaje = "Error al conectar con la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }


}
