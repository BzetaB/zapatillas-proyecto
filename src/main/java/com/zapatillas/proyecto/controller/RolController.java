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
    public Rol createRol(@RequestBody Rol rol){
        return iRolService.guardarRol(rol);
    }

    //read
    @GetMapping("/listar")
    @ResponseBody
    public List<Rol> rolList(){
        return iRolService.listarRol();
    }

    //update
    @PutMapping("/{id}")
    @ResponseBody
    public Rol updateRol(@PathVariable("id") int id,
                         @RequestBody Rol rol){
        return iRolService.actualizarRol(rol);
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

    @GetMapping("/{id}")
    @ResponseBody
    public Rol obtenerRol(@PathVariable("id") Integer id){
        return iRolService.obtenerRolPorId(id);
    }

}
