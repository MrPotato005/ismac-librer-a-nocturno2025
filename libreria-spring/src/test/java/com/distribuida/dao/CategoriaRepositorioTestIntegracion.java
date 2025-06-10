package com.distribuida.dao;

import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class CategoriaRepositorioTestIntegracion {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Test
    public void findAll() {
        List<Categoria> categorias = categoriaRepositorio.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size() > 0);

        for (Categoria item : categorias) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<Categoria> categoria = categoriaRepositorio.findById(1);
        assertTrue(categoria.isPresent(), "La categoría con id=1 debería existir");
        System.out.println(categoria.toString());
    }

    @Test
    public void save() {
        Categoria categoria = new Categoria(0, "Tecnología", "Libros relacionados a tecnología y programación");
        Categoria categoriaGuardada = categoriaRepositorio.save(categoria);
        assertNotNull(categoriaGuardada.getIdCategoria(), "La categoría guardada debe tener un id");
        assertEquals("Tecnología", categoriaGuardada.getCategoria());
    }

    @Test
    public void update() {
        Optional<Categoria> categoriaExistente = categoriaRepositorio.findById(1);
        assertTrue(categoriaExistente.isPresent());

        categoriaExistente.orElse(null).setCategoria("Ciencia Ficción");
        categoriaExistente.orElse(null).setDescripcion("Libros sobre ciencia ficción y futuros imaginarios");

        Categoria categoriaActualizada = categoriaRepositorio.save(categoriaExistente.orElse(null));

        assertEquals("Ciencia Ficción", categoriaActualizada.getCategoria());
    }

    @Test
    public void delete() {
        int idEliminar = 1; // Asegúrate que este ID existe para la prueba
        if (categoriaRepositorio.existsById(idEliminar)) {
            categoriaRepositorio.deleteById(idEliminar);
        }
        assertFalse(categoriaRepositorio.existsById(idEliminar), "La categoría con id=" + idEliminar + " debería haberse eliminado");
    }
}
