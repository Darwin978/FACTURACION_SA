package com.guia.practica.Modelos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class RolxCompetencia {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol_competencia;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "id_competencias", nullable = false)
    private Competencia competencia;

    public RolxCompetencia(Integer id_rol_competencia, Rol rol, Competencia competencia) {
        this.id_rol_competencia = id_rol_competencia;
        this.rol = rol;
        this.competencia = competencia;
    }

    public RolxCompetencia() {

    }
}
