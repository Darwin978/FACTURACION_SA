package com.guia.practica.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Clasificacion {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_clasificacion;
    private String grupo;

    @OneToMany(mappedBy = "clasificacion")
    private List<Producto> productosList;

    public Clasificacion(Integer id_clasificacion, String grupo) {
        this.id_clasificacion = id_clasificacion;
        this.grupo = grupo;
    }

    public Clasificacion() {
    }
}
