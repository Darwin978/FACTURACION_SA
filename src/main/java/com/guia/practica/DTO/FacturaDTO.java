package com.guia.practica.DTO;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class FacturaDTO {
    private Integer id_factura;
    private String ruc;
    private Date fecha;
    private double descuento;
    private double total;

    private List<ItemFacturaDTO> idItems;
    private Integer idTipoPago;
    private Integer idPersona;


}
