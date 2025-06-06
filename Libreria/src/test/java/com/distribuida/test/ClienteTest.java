package com.distribuida.test;

import com.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {



    private Cliente cliente;


    @BeforeEach

    public void setUp(){

        cliente = new Cliente(1,"1753595917", "Pepe", "Gustavo","Av. por ahi","0956486584","pepe@gmail.com" );
    }


@Test

    public void testClienteConstructorAndGetters(){

        assertAll("Validad Datos Cliente",
                () ->  assertEquals(1, cliente.getId_cliente()),
                () -> assertEquals("1753595917", cliente.getCedula()),
                () -> assertEquals("Pepe", cliente.getNombre()),
                () -> assertEquals("Gustavo", cliente.getApellido()),
                () -> assertEquals("Av. por ahi", cliente.getDirreccion()),
                () -> assertEquals("0956486584", cliente.getTelefono()),
                () -> assertEquals("pepe@gmail.com", cliente.getCorreo())
        );

}


@Test


    public void testClienteSetters(){


        cliente  = new Cliente();

        cliente.setId_cliente(2);
        cliente.setCedula("1764512612");
        cliente.setNombre("Pepe2");
        cliente.setApellido("Gustavo2");
        cliente.setDirreccion("Av. por ahi 2");
        cliente.setTelefono("09155313122");
        cliente.setCorreo("pepe2@gmail.com");

  assertAll(
          "Validar Datos Cliente",
          ()-> assertEquals(2,cliente.getId_cliente()),
          ()-> assertEquals("Pepe2",cliente.getNombre()),
          ()-> assertEquals("Gustavo2",cliente.getApellido()),
          ()-> assertEquals("Av. por ahi 2",cliente.getDirreccion()),
          ()-> assertEquals("09155313122",cliente.getTelefono()),
          ()-> assertEquals("pepe2@gmail.com",cliente.getCorreo())

          );









}

@Test
    public void testToString(){

String str = cliente.toString();
assertAll(  "Validad Datos de Cliente",

        () -> assertTrue(str.contains("1")),
        () -> assertTrue(str.contains("1753595917")),
        () -> assertTrue(str.contains("Pepe")),
        () -> assertTrue(str.contains("Gustavo")),
        () -> assertTrue(str.contains("Av. por ahi")),
        () -> assertTrue(str.contains("0956486584")),
        () -> assertTrue(str.contains("pepe@gmail.com"))


);



}












}
