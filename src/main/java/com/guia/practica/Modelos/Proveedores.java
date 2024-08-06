package com.guia.practica.Modelos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Proveedores {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_proveedor;
    private String ruc;
    private String telefono;
    private String pais;
    private String correo;
    private String moneda;

    @OneToMany(mappedBy = "proveedores")
    private List<Producto> productosList;

    public Proveedores() {
    }

    public Proveedores(Integer id_proveedor, String ruc, String telefono, String pais, String correo, String moneda) {
        this.id_proveedor = id_proveedor;
        this.ruc = ruc;
        this.telefono = telefono;
        this.pais = pais;
        this.correo = correo;
        this.moneda = moneda;
    }
}
