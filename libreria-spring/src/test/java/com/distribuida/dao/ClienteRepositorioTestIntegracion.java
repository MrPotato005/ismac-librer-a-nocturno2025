package com.distribuida.dao;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ClienteRepositorioTestIntegracion {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void findAll() {

        List<Cliente> clientes = clienteRepositorio.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for (Cliente item : clientes) {

            System.out.println(item.toString());

        }


    }


@Test
    public void findOne(){

        Optional<Cliente> cliente = clienteRepositorio.findById(1);
        assertTrue(cliente.isPresent(),"El cliente con id=39 deberia existir ");
        System.out.println(cliente.toString());


}

@Test
    public void save(){
        Cliente cliente = new Cliente(0,"17532564656","Pepe","juanito","Av. por ahy","095531533", "juanito.gmail.com");
        Cliente clienteGuardado = clienteRepositorio.save(cliente);
        assertNotNull(clienteGuardado.getId_cliente(), "el cliente guardado debe tener un id");
        assertEquals("17532564656",clienteGuardado.getCedula());
    assertEquals("Pepe",clienteGuardado.getNombre());

}
@Test
    public void update(){

        Optional<Cliente> clienteExistente = clienteRepositorio.findById(40);

        assertTrue(clienteExistente.isPresent());

        clienteExistente.orElse(null).setCedula("17846589389");
    clienteExistente.orElse(null).setNombre("Pepe2");
    clienteExistente.orElse(null).setApellido("Juanito2");
    clienteExistente.orElse(null).setDirreccion("AV. 2550");
    clienteExistente.orElse(null).setTelefono("086146435684");
    clienteExistente.orElse(null).setCorreo("juanito12@gmail.com");

   Cliente clienteActualizado = clienteRepositorio.save(clienteExistente.orElse(null));

    assertEquals("Pepe2", clienteActualizado.getNombre());
    assertEquals("Juanito2", clienteActualizado.getApellido());

    }

@Test

    public void delete(){

        if(clienteRepositorio.existsById(40)){
            clienteRepositorio.deleteById(40);

        }
assertFalse(clienteRepositorio.existsById(40), "El id=40 deberia haberse eliminado");


}


}
