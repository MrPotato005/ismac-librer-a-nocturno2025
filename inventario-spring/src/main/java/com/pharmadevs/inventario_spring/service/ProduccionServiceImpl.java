package com.pharmadevs.inventario_spring.service;

import com.pharmadevs.inventario_spring.dao.ProduccionRepositorio;
import com.pharmadevs.inventario_spring.model.Produccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduccionServiceImpl implements ProduccionService {

    @Autowired
    private ProduccionRepositorio produccionRepositorio;

    @Override
    public List<Produccion> findAll() {
        return produccionRepositorio.findAll();
    }

    @Override
    public Produccion findOne(int id) {
        Optional<Produccion> produccion = produccionRepositorio.findById(id);
        return produccion.orElse(null);
    }

    @Override
    public Produccion save(Produccion produccion) {
        return produccionRepositorio.save(produccion);
    }

    @Override
    public Produccion update(int id, Produccion produccion) {
        Produccion produccionExistente = findOne(id);
        if (produccionExistente == null) {
            return null;
        }
        // Actualizar campos según el diagrama ER
        produccionExistente.setIdProduccion(produccion.getIdProduccion());
        produccionExistente.setFechaProduccion(produccion.getFechaProduccion());
        produccionExistente.setFechaVencimiento(produccion.getFechaVencimiento());
        produccionExistente.setLote(produccion.getLote());
        produccionExistente.setCantidadProducida(produccion.getCantidadProducida());

        return produccionRepositorio.save(produccionExistente);
    }

    @Override
    public void delete(int id) {
        if (produccionRepositorio.existsById(id)) {
            produccionRepositorio.deleteById(id);
        }
    }
}
