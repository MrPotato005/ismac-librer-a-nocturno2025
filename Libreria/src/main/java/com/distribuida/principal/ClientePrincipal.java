package com.distribuida.principal;

import com.distribuida.entities.Cliente;

public class ClientePrincipal {

    public static void main(String[] args){

        Cliente cliente = new Cliente(1, "17535864185", "Juan" ,"Taipe", "Av, por ahi ", "05165156156", "juan@gmail.com");

        System.out.println(cliente.toString());

    }

}
