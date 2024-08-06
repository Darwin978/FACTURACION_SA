package com.guia.practica.Modelos;

import com.guia.practica.Repositorios.RolRepository;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String usuario;
    private String password;

    @ManyToOne
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona")
    private Persona persona;

    @OneToMany(mappedBy = "usuarioRol")
    private List<RolxUsuario> rolxUsuarioList;


    public Usuario(Integer id_usuario, String usuario, String password, Persona persona) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.password = password;
        this.persona = persona;
    }

    public Usuario() {
    }
}
