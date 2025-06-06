package com.distribuida.principal;

import com.distribuida.entities.Autor;

public class AutorPrincipal {

    public static void main(String[] args) {

        Autor autor = new Autor(
                1,
                "Gabriel",
                "García Márquez",
                "Colombiano",
                "gabriel.garcia@example.com"
        );

        System.out.println(autor.toString());
    }
}
