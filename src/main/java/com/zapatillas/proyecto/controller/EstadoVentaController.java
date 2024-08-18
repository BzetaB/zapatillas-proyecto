package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.EstadoVenta;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IEstadoVentaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/estadoventa")
public class EstadoVentaController {
    private IEstadoVentaService iEstadoVentaService;

    @GetMapping("/registro")
    public String frmEstadoventa(Model model){
        model.addAttribute("listaestadoventa",
                iEstadoVentaService.listarEstadosVenta());
        return "venta/frmestadoventa";
    }

    //create
    @PostMapping("/create")
    @ResponseBody
    public RespuestaGeneral createEstado(@RequestBody EstadoVenta estadoVenta){
        String mensaje = "Estado de Venta creado";
        boolean resultado = true;
        try {
            iEstadoVentaService.guardarEstado(estadoVenta);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al guardar el estado";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //read
    @GetMapping("/listar")
    @ResponseBody
    public List<EstadoVenta> estadoVentaList(){
        return iEstadoVentaService.listarEstadosVenta();
    }

    //update
    @PostMapping("/update")
    @ResponseBody
    public RespuestaGeneral updateEstado(@RequestBody EstadoVenta estadoVenta){
        String mensaje = "Estado de Venta Actualizado";
        boolean resultado = true;
        try {
            iEstadoVentaService.actualizarEstado(estadoVenta);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al actualizar";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //delate
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral deleteEstado(@PathVariable("id") int id){
        String mensaje = "Estado de Venta Eliminado";
        boolean resultado = true;
        try {
            iEstadoVentaService.eliminarEstado(id);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al eliminar";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }
}
