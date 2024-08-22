package com.zapatillas.proyecto.service;

import com.zapatillas.proyecto.model.bd.Categoria;
import com.zapatillas.proyecto.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoriaService implements ICategoriaService {

    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria obtenerCategoriaPorCatename(String catename) {

        return categoriaRepository.findByCatename(catename);
    }

    @Override
    public List<Categoria> listarCategorias() {

        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorId(Integer id) {

        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria){
        Categoria updateCategoria = this.obtenerCategoriaPorId(categoria.getIdcategoria());
        updateCategoria.setCatename(categoria.getCatename());
        return categoriaRepository.save(updateCategoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Categoria con ID " + id + " no encontrado");
        }
    }
}

