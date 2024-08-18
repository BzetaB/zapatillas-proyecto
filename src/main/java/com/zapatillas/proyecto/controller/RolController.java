package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Rol;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IRolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/rol")
public class RolController {
    private IRolService iRolService;
    @GetMapping("/registro")
    public String frmRol(Model model){
        model.addAttribute("listaRol",iRolService.listarRol());
        return "colaborador/frmrol";
    }

    //create
    @PostMapping("/create")
    @ResponseBody
    public RespuestaGeneral createRol(@RequestBody Rol rol){
        String mensaje = "Rol creado correctamente";
        boolean resultado = true;
        try {
            iRolService.guardarRol(rol);
        }catch (Exception ex){
            mensaje = "Error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //read
    @GetMapping("/listar")
    @ResponseBody
    public List<Rol> rolList(){
        return iRolService.listarRol();
    }

    //update
    @PostMapping("/update")
    @ResponseBody
    public RespuestaGeneral updateRol(@RequestBody Rol rol){
        String mensaje = "Rol actualizado correctamente";
        boolean resultado = true;
        try {
            iRolService.actualizarRol(rol);
        }catch (Exception ex){
            mensaje = "Error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    //DELETE
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral updateRol(@PathVariable("id") int id){
        String mensaje = "Rol eliminado correctamente";
        boolean resultado = true;
        try {
            iRolService.eliminarRol(id);
        }catch (Exception ex){
            mensaje = "Error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

}
