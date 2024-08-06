package com.guia.practica.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RolxUsuario {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol_usuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuarioRol;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rolUsuario;

    public RolxUsuario(Integer id_rol_usuario, Usuario usuarioRol, Rol rolUsuario) {
        this.id_rol_usuario = id_rol_usuario;
        this.usuarioRol = usuarioRol;
        this.rolUsuario = rolUsuario;
    }

    public RolxUsuario() {
    }
}
