package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.*;
import com.zapatillas.proyecto.model.dto.ProductoDto;
import com.zapatillas.proyecto.repository.CategoriaRepository;
import com.zapatillas.proyecto.repository.MarcaRepository;
import com.zapatillas.proyecto.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductoService implements IProductoService {
    private ProductoRepository productoRepository;
    private CategoriaRepository categoriaRepository;
    private MarcaRepository marcaRepository;

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto guardarProducto(ProductoDto productoDto) {
        Producto nuevoProducto = new Producto();
        nuevoProducto.setPname(productoDto.getPname());
        nuevoProducto.setPdesc(productoDto.getPdesc());
        nuevoProducto.setPprecio(productoDto.getPprecio());
        nuevoProducto.setPstock(productoDto.getPstock());
        nuevoProducto.setPtalla(productoDto.getPtalla());

        Categoria categoria = new Categoria();
        categoria.setIdcategoria(productoDto.getIdcategoria());

        nuevoProducto.setCategoria(categoria);

        Marca marca = new Marca();
        marca.setIdmarca(productoDto.getIdmarca());

        nuevoProducto.setMarca(marca);

        return productoRepository.save(nuevoProducto);
    }

    @Override
    public Producto actualizarProducto(ProductoDto productoDto) {
        Producto updateProducto = productoRepository.findById(
                productoDto.getIdproducto()).orElse(null);
        updateProducto.setPname(productoDto.getPname());
        updateProducto.setPdesc(productoDto.getPdesc());
        updateProducto.setPprecio(productoDto.getPprecio());
        updateProducto.setPstock(productoDto.getPstock());
        updateProducto.setPtalla(productoDto.getPtalla());

        if (productoDto.getIdcategoria() != null) {
            // Cargar el TipoDocumentoColaborador existente desde la base de datos
            Categoria categoria = categoriaRepository.findById(productoDto.getIdcategoria()).orElse(null);

            updateProducto.setCategoria(categoria);
        } else {
            // Manejar el caso en que iddocumento no se proporciona
            updateProducto.setCategoria(null);
        }

        if (productoDto.getIdmarca() != null) {
            // Cargar el TipoDocumentoColaborador existente desde la base de datos
            Marca marca = marcaRepository.findById(productoDto.getIdmarca()).orElse(null);

            updateProducto.setMarca(marca);
        } else {
            // Manejar el caso en que iddocumento no se proporciona
            updateProducto.setMarca(null);
        }


        return productoRepository.save(updateProducto);
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(Integer id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto con ID " + id + " no encontrado");
        }
    }
}

