package com.guia.practica.Modelos;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Competencia {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_competencias;
    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "competencia")
    private List<RolxCompetencia> rolxCompetenciaList;

    public Competencia(Integer id_competencias, String nombre, String descripcion) {
        this.id_competencias = id_competencias;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Competencia(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Competencia() {
    }

    public boolean existeComp(String nombre) {
        // Implementación del método
        return true; // Ejemplo
    }



}
