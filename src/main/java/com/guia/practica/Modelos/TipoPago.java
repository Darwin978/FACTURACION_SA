package com.guia.practica.Modelos;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TipoPago {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;
    private String tipo;
    private String descri;

    @OneToMany(mappedBy = "tipoPago")
    private List<Factura> facturaList;

    public TipoPago() {
    }

    public TipoPago(Integer id_tipo_pago, String tipo, String descri) {
        this.idTipoPago = id_tipo_pago;
        this.tipo = tipo;
        this.descri = descri;
    }
}
