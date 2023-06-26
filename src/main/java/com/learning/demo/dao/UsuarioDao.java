package com.learning.demo.dao;

import com.learning.demo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuario();

    void deleteUsuario(int id);

    void registrarUsuario(Usuario usuario);

    boolean verificarUsuario(Usuario usuario);
}
