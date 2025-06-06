package com.distribuida.principal;

import com.distribuida.entities.Categoria;

public class CategoriaPrincipal {

    public static void main(String[] args) {

        Categoria categoria = new Categoria(
                1,
                "Programación",
                "Libros relacionados con desarrollo de software y programación"
        );

        System.out.println(categoria.toString());
    }
}
