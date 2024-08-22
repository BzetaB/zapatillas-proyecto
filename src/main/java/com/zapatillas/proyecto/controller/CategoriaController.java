package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Categoria;
import com.zapatillas.proyecto.model.bd.Rol;
import com.zapatillas.proyecto.model.dto.RespuestaGeneral;
import com.zapatillas.proyecto.service.ICategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private ICategoriaService categoriaService;

    private ICategoriaService iCategoriaService;
    @GetMapping("/register")
    public String frmRol(Model model){
        model.addAttribute("listaCategoria",iCategoriaService.listarCategorias());
        return "categoria/frmrol";
    }

    @PostMapping("/create")
    @ResponseBody
    public Categoria createCategoria(@RequestBody Categoria categoria ){
        return iCategoriaService.guardarCategoria(categoria);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Categoria> categoriaList(){
        return iCategoriaService.listarCategorias();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Categoria updateCategoria(@PathVariable("id") int id,
                             @RequestBody Categoria categoria) {
        return iCategoriaService.actualizarCategoria(categoria);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public RespuestaGeneral updateCategoria(@PathVariable("id") int id){
        String mensaje = "Categoria eliminada correctamente";
        boolean resultado = true;
        try {
            iCategoriaService.eliminarCategoria(id);
        }catch (Exception ex){
            mensaje = "Error al conectarse a la BD";
            resultado = false;
        }
        return RespuestaGeneral.builder().mensaje(mensaje).resultado(resultado).build();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Categoria obtenerCategoria(@PathVariable("id") Integer id){
        return iCategoriaService.obtenerCategoriaPorId(id);
    }
}

