package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.MetodoDePago;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IMetodoDePagoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/metodopago")
public class MetodoDePagoController {
    private IMetodoDePagoService iMetodoDePagoService;
    @GetMapping("/registro")
    public String frmMetodoPago(Model model){
        model.addAttribute(
                "listarmetodospago",
                iMetodoDePagoService.listarMetodosPago());
        return "venta/frmmetodopago";
    }

    //create
    @PostMapping("/create")
    @ResponseBody
    public MetodoDePago createMetodoPago(@RequestBody MetodoDePago metodoDePago){
        return iMetodoDePagoService.guardarMetodo(metodoDePago);
    }

    //read
    @GetMapping("/listar")
    @ResponseBody
    public List<MetodoDePago> metodoDePagoList(){
        return iMetodoDePagoService.listarMetodosPago();
    }


    //update
    @PutMapping("/{id}")
    @ResponseBody
    public MetodoDePago updateMetodo(@PathVariable("id") int id,
                                     @RequestBody MetodoDePago metodoDePago){
        return iMetodoDePagoService.actualizarMetodoPago(metodoDePago);
    }

    //delete
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral updateMetodo(@PathVariable("id") int id){
        String mensaje = "Metodo de Pago eliminado con exito.";
        boolean resultado = true;
        try {
            iMetodoDePagoService.eliminarMetodoPago(id);
        }catch (Exception ex){
            mensaje= "Error: Ocurrio un error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public MetodoDePago obtenerMetododePago(@PathVariable("id") Integer id){
        return iMetodoDePagoService.obtenerMetodoPorId(id);
    }

}
