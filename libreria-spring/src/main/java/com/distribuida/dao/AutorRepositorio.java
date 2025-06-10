package com.distribuida.dao;

import com.distribuida.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<Autor, Integer> {
}
