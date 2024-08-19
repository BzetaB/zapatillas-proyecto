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

    //create
    @PostMapping("/registrar")
    @ResponseBody
    public Colaborador guardarCategoria(@RequestBody ColaboradorDto colaboradorDto){
        return iColaboradorService.guardarColaborador(colaboradorDto);
    }


    //read
    @GetMapping("/listar")
    @ResponseBody
    public List<Colaborador> colaboradorList(){
        return iColaboradorService.listarColaboradores();
    }

    //update
    @PutMapping("/{id}")
    @ResponseBody
    public Colaborador actualizar(@PathVariable("id") Integer id,
                                  @RequestBody ColaboradorDto colaboradorDto) {
            return iColaboradorService.actualizarColab(colaboradorDto);
    }

    //delete
    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral eliminar(@PathVariable("id") int id) {
        String mensaje="Colaborador actualizado correctamente";
        boolean resultado= true;
        try {
            iColaboradorService.eliminarColaboradorPorId(id);
        }catch (Exception ex){
            mensaje="Error: Ocurrio un error al conectarse a la BD";
            resultado= false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();

    }

    @GetMapping("/{id}")
    @ResponseBody
    public Colaborador obtenerColaborador(@PathVariable("id") Integer id){
        return iColaboradorService.obtenerColaboradorPorId(id);
    }



}
