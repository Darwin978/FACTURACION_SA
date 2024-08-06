package com.guia.practica.Modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Persona {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String correo;

    @OneToMany(mappedBy = "personaFactura")
    private List<Factura> facturaList;

    @OneToMany(mappedBy = "persona")
    private List<Usuario> usuarioList;

    public Persona(Integer id_persona, String nombre, String apellido, String dni, String celular, String correo) {
        this.idPersona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
    }

    public Persona() {
    }
}
