package com.guia.practica.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Rol {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;
    private String rol;
    private boolean estado;


    @OneToMany(mappedBy = "rol")
    private List<RolxCompetencia> rolxCompetenciaList;

    @OneToMany(mappedBy = "rolUsuario")
    private List<RolxUsuario> rolxUsuarioList;

    // Métodos de negocio
    public boolean existeRol(String rol) {
        // Implementación del método
        return true; // Ejemplo
    }

    public boolean estado(String rol) {
        // Implementación del método
        return true; // Ejemplo
    }

    public Rol(Integer id_rol, String rol, boolean estado) {
        this.id_rol = id_rol;
        this.rol = rol;
        this.estado = estado;
    }

    public Rol() {
    }
}
