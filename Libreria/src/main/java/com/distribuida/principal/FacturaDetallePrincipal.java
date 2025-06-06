package com.distribuida.principal;

import com.distribuida.entities.Factura;
import com.distribuida.entities.FacturaDetalle;
import com.distribuida.entities.Cliente;
import com.distribuida.entities.Libro;

import java.util.Date;

public class FacturaDetallePrincipal {

    public static void main(String[] args) {

        // Crear cliente
        Cliente cliente = new Cliente(1, "17535864185", "Juan", "Taipe", "Av, por ahi", "05165156156", "juan@gmail.com");

        // Crear factura e inyectar cliente
        Factura factura = new Factura(1, "Fac-00001", new Date(), 10.00, 15.00, 115.00, cliente);

        // Crear libro
        Libro libro = new Libro(1, "Java desde Cero", "Mario Ruiz", 20.00, 10, "Tecnología");

        // Crear detalle de factura e inyectar factura y libro
        FacturaDetalle detalle = new FacturaDetalle(1, 2, 40.00, factura, libro);

        // Mostrar detalle
        System.out.println(detalle.toString());
    }
}
