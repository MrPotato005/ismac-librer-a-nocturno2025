package com.distribuida.dao;

import com.distribuida.model.Autor;
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
public class AutorRepositorioTestIntegracion {

    @Autowired
    private AutorRepositorio autorRepositorio;

    @Test
    public void findAll() {
        List<Autor> autores = autorRepositorio.findAll();
        assertNotNull(autores);
        assertTrue(autores.size() > 0);

        for (Autor item : autores) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne() {
        Optional<Autor> autor = autorRepositorio.findById(1);
        assertTrue(autor.isPresent(), "El autor con id=1 debería existir");
        System.out.println(autor.toString());
    }

    @Test
    public void save() {
        Autor autor = new Autor(0, "Gabriel", "García Márquez", "Colombia", "Calle Real", "0987654321", "gabriel@gmail.com");
        Autor autorGuardado = autorRepositorio.save(autor);
        assertNotNull(autorGuardado.getIdAutor(), "El autor guardado debe tener un id");
        assertEquals("Gabriel", autorGuardado.getNombre());
    }

    @Test
    public void update() {
        Optional<Autor> autorExistente = autorRepositorio.findById(1);
        assertTrue(autorExistente.isPresent());

        autorExistente.orElse(null).setNombre("Gabriel Actualizado");
        autorExistente.orElse(null).setApellido("Márquez Actualizado");
        autorExistente.orElse(null).setDireccion("Nueva Dirección 123");
        autorExistente.orElse(null).setTelefono("0981234567");
        autorExistente.orElse(null).setCorreo("actualizado@gmail.com");

        Autor autorActualizado = autorRepositorio.save(autorExistente.orElse(null));

        assertEquals("Gabriel Actualizado", autorActualizado.getNombre());
        assertEquals("Márquez Actualizado", autorActualizado.getApellido());
    }

    @Test
    public void delete() {
        int idEliminar = 1; // Asegúrate que este ID existe para la prueba
        if (autorRepositorio.existsById(idEliminar)) {
            autorRepositorio.deleteById(idEliminar);
        }
        assertFalse(autorRepositorio.existsById(idEliminar), "El autor con id=" + idEliminar + " debería haberse eliminado");
    }
}
