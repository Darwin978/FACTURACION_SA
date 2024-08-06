package com.guia.practica.Modelos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ItemFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idItemFactura;

    @ManyToOne
    @JoinColumn(name = "idFactura", referencedColumnName = "idFactura")
    private Factura factura;
    private int cantidad;
    private double precio;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto idProducto;

}
