package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.model.dto.ColaboradorDto;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.IColaboradorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/colaborador")
public class ColaboradorController {
    private IColaboradorService iColaboradorService;
    @GetMapping("/registro")
    public String frmColaborador(Model model){
        model.addAttribute("listacolaborador",
                iColaboradorService.listarColaboradores());
        return "colaborador/frmcolaborador";
    }

    @PostMapping("/registrar")
    @ResponseBody
    public RespuestaGeneral guardarCategoria(@RequestBody ColaboradorDto colaboradorDto){
        String mensaje="Categoria registrada correctamente";
        boolean resultado= true;
        try {
            iColaboradorService.guardarColaborador(colaboradorDto);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Colaborador obtenerColaborador(
            @PathVariable("id") int id
    ){
        return iColaboradorService.obtenerColaboradorPorId(id);
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<Colaborador> colaboradorList(){
        return iColaboradorService.listarColaboradores();
    }


}
