package com.learning.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    public Usuario(){
    }

    @Getter @Setter @Column(name = "id") @Id
    private int id;
    @Getter @Setter @Column(name = "Nombre")
    private String nombre;
    @Getter @Setter @Column(name = "Apellido")
    private String apellido;
    @Getter @Setter @Column(name = "telefono")
    private String telefono;
    @Getter @Setter @Column(name = "Email")
    private String email;
    @Getter @Setter @Column(name = "contrasena")
    private String password;

}
