package com.pharmadevs.inventario_spring.dao;

import com.pharmadevs.inventario_spring.model.Produccion;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ProduccionRepositorioTestIntegracion {

    @Autowired
    private ProduccionRepositorio produccionRepositorio;

    @Test
    public void findAllProducciones() {
        List<Produccion> producciones = produccionRepositorio.findAll();
        assertNotNull(producciones);
        assertFalse(producciones.isEmpty(), "La lista de producciones no debe estar vacía");
        producciones.forEach(System.out::println);
    }

    @Test
    public void findProduccionById() {
        Optional<Produccion> produccion = produccionRepositorio.findById(1);
        assertTrue(produccion.isPresent(), "El registro de producción con id=1 debería existir");
        produccion.ifPresent(System.out::println);
    }

    @Test
    public void saveProduccion() {
        LocalDate fechaProd = LocalDate.now();
        LocalDate fechaVenc = fechaProd.plusMonths(6);

        Produccion nuevaProduccion = new Produccion();
        // NO seteamos el ID si es autogenerado

        nuevaProduccion.setLote("LOTE-2023-001");
        nuevaProduccion.setCantidadProducida(100);

        Produccion produccionGuardada = produccionRepositorio.save(nuevaProduccion);
        assertNotNull(produccionGuardada.getIdProduccion(), "El registro de producción guardado debe tener un id");
        assertEquals("LOTE-2023-001", produccionGuardada.getLote());
    }

    @Test
    public void updateProduccion() {
        Optional<Produccion> produccionExistente = produccionRepositorio.findById(1);
        assertTrue(produccionExistente.isPresent());

        Produccion produccion = produccionExistente.get();

        produccion.setLote("LOTE-2023-002");
        produccion.setCantidadProducida(150);

        Produccion produccionActualizada = produccionRepositorio.save(produccion);

        assertEquals("LOTE-2023-002", produccionActualizada.getLote());
        assertEquals(150, produccionActualizada.getCantidadProducida());
    }

    @Test
    public void deleteProduccion() {
        if (produccionRepositorio.existsById(1)) {
            produccionRepositorio.deleteById(1);
        }
        assertFalse(produccionRepositorio.existsById(1), "El registro con id=1 debería haberse eliminado");
    }
}
