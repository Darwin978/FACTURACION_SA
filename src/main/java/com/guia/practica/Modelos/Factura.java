package com.guia.practica.Modelos;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Entity
@Data
public class Factura {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    private String ruc;
    private Date fecha;
    private double descuento;
    private double total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemFactura> itemsFactura;

    @ManyToOne
    @JoinColumn(name = "idTipoPago", nullable = false)
    private TipoPago tipoPago;

    @ManyToOne
    @JoinColumn(name = "idPersona", nullable = false)
    private Persona personaFactura;


}
