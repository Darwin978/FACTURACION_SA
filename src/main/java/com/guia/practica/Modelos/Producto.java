package com.guia.practica.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Producto {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;
    private int stock;
    private double precio_unitario;
    private String unidad;
    private boolean iva;

    @OneToMany(mappedBy = "idProducto")
    private List<ItemFactura> itemFactura;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedores proveedores;

    @ManyToOne
    @JoinColumn(name = "id_clasificacion", nullable = false)
    private Clasificacion clasificacion;

    public Producto() {
    }

    public Producto(Integer id_producto, int stock, double precio_unitario, String unidad, boolean iva, Proveedores proveedores, Clasificacion clasificacion) {
        this.idProducto = id_producto;
        this.stock = stock;
        this.precio_unitario = precio_unitario;
        this.unidad = unidad;
        this.iva = iva;
        this.proveedores = proveedores;
        this.clasificacion = clasificacion;
    }
}
