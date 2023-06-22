package com.learning.demo.controllers;

import com.learning.demo.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable int id){
        Usuario user = new Usuario();
        user.setApellido("Maciel");
        user.setEmail("maciel@gmail.es");
        user.setNombre("Federico");
        user.setTelefono("761723584");
        user.setId(id);
        return user;
    }

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){

        List<Usuario> usuarios = new ArrayList<>();
        Usuario user1 = new Usuario();
        user1.setApellido("Maciel");
        user1.setEmail("maciel@gmail.es");
        user1.setNombre("Federico");
        user1.setTelefono("761723584");
        user1.setId(1);

        Usuario user2 = new Usuario();
        user2.setApellido("Hernandez");
        user2.setEmail("hf32@gmail.es");
        user2.setNombre("Fernando");
        user2.setTelefono("712344");
        user2.setId(2);

        Usuario user3 = new Usuario();
        user3.setApellido("Aleman");
        user3.setEmail("ga@gmail.es");
        user3.setNombre("Gaston");
        user3.setTelefono("87162412");
        user3.setId(3);

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);

        return usuarios;
    }
}
