package com.distribuida.service;
import com.distribuida.dao.CategoriaRepositorio;
import com.distribuida.dao.CategoriaRepositorio;
import com.distribuida.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepositorio categoriaRepository;

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findOne(int id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return null;
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria update(int id, Categoria categoriaNuevo) {
        Categoria categoriaExistente = findOne(id);

        if (categoriaExistente == null){
            return null;
        }

        categoriaExistente.setCategoria(categoriaNuevo.getCategoria());
        categoriaExistente.setDescripcion(categoriaNuevo.getDescripcion());

        return categoriaRepository.save(categoriaExistente);
    }

    @Override
    public void delete(int id) {

        if (categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
        }

    }
}
