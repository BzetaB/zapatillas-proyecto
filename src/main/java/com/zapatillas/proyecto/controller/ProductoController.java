package com.zapatillas.proyecto.controller;

import com.zapatillas.proyecto.model.bd.Colaborador;
import com.zapatillas.proyecto.model.bd.Producto;
import com.zapatillas.proyecto.model.dto.ProductoDto;
import com.zapatillas.proyecto.service.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/productos")
public class ProductoController {

    private IProductoService productoService;

    @GetMapping("/listar")
    @ResponseBody
    public List<Producto> listarProductos(){
        return productoService.listarProductos();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public Producto guardarProducto(@RequestBody ProductoDto productoDto) {
        return productoService.guardarProducto(productoDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Producto actualizar(@PathVariable("id") Integer id,
                                  @RequestBody ProductoDto productoDto) {
            return productoService.actualizarProducto(productoDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Producto obtenerProducto(@PathVariable("id") Integer id){
        return productoService.buscarProductoPorId(id);
    }
}
