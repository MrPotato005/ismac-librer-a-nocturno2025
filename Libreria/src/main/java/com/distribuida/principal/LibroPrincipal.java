package com.distribuida.principal;

import com.distribuida.entities.Libro;

public class LibroPrincipal {

    public static void main(String[] args) {

        Libro libro = new Libro(
                1,
                "Cien años de soledad",
                "Gabriel García Márquez",
                20.50,
                10,
                "Editorial Sudamericana"
        );

        System.out.println(libro.toString());
    }
}
