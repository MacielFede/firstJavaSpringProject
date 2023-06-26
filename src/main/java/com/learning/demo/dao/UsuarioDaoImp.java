package com.learning.demo.dao;

import com.learning.demo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager; //Esto nos ayuda a hacer las consultas sql
    @Override
    public List<Usuario> getUsuario() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteUsuario(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarUsuario(Usuario usuario){
        String query = "FROM Usuario WHERE Email = :email";
        List<Usuario> listaUsers = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();
        if(listaUsers.isEmpty()) return false;

        String hashedPass = listaUsers.get(0).getPassword();

        Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon.verify(hashedPass, usuario.getPassword());
    }
}
