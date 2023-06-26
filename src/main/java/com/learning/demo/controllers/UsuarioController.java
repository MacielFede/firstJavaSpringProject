package com.learning.demo.controllers;

import com.learning.demo.dao.UsuarioDao;
import com.learning.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/usuarios/{id}")
    public Usuario getUsuario(@PathVariable int id){
        //TODO: hacer una query y retornar la info del user
        Usuario user = new Usuario();
        user.setApellido("Maciel");
        user.setEmail("maciel@gmail.es");
        user.setNombre("Federico");
        user.setTelefono("761723584");
        user.setId(id);
        return user;
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){return usuarioDao.getUsuario();}

    @RequestMapping(value="api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable int id){
        usuarioDao.deleteUsuario(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hashedPass = argon.hash(1, 1024, 1, usuario.getPassword());

        usuario.setPassword(hashedPass);
        usuarioDao.registrarUsuario(usuario);
    }
}
