package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Venta;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.model.dto.VentaDto;
import com.zapatillas.proyecto.service.IVentaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/venta")
public class VentaController {

    private IVentaService iVentaService;
    @GetMapping("/registro")
    public String frmVenta(Model model){
        model.addAttribute("listaVenta", iVentaService.listarVenta());
        return "venta/frmventa";
    }

    //create
    @PostMapping("/create")
    @ResponseBody
    public RespuestaGeneral createVenta(@RequestBody VentaDto ventaDto){
        String mensaje = "Venta creada correctamente";
        boolean resultado = true;
        try {
            iVentaService.guardarVenta(ventaDto);
        }catch (Exception ex){
            mensaje = "Error al conectar la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //Read
    @GetMapping("/listar")
    @ResponseBody
    public List<Venta> ventaList(){
        return iVentaService.listarVenta();
    }

    //actualizar
    @PostMapping("/update")
    @ResponseBody
    public RespuestaGeneral updateVenta(@RequestBody VentaDto ventaDto){
        String mensaje = "Venta actualizada correctamente";
        boolean resultado = true;
        try {
            iVentaService.actualizarVenta(ventaDto);
        }catch (Exception ex){
            mensaje = "Error al conectar la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //delete
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral deleteVenta(@PathVariable("id") int id){
        String mensaje = "Venta eliminada correctamente";
        boolean resultado = true;
        try {
            iVentaService.eliminarVenta(id);
        }catch (Exception ex){
            mensaje = "Error al conectar la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

}
