package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Marca;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
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

    private IMarcaService iMarcaService;
    @GetMapping("/register")
    public String frmRol(Model model){
        model.addAttribute("listaMarca",iMarcaService.listarMarcas());
        return "marca/frmrol";
    }

    @PostMapping("/create")
    @ResponseBody
    public Marca createMarca(@RequestBody Marca marca ){
        return iMarcaService.guardarMarca(marca);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Marca> rolList(){
        return iMarcaService.listarMarcas();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Marca updateMarca(@PathVariable("id") int id,
                             @RequestBody Marca marca){
        return iMarcaService.actualizarMarca(marca);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral updateMarca(@PathVariable("id") int id){
        String mensaje = "Marca eliminada correctamente";
        boolean resultado = true;
        try {
            iMarcaService.eliminarMarca(id);
        }catch (Exception ex){
            mensaje = "Error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Marca obtenerMarca(@PathVariable("id") Integer id){
        return iMarcaService.obtenerMarcaPorId(id);
    }
}

