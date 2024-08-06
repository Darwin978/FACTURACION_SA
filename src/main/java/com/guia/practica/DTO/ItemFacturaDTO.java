package com.guia.practica.DTO;

import lombok.Data;

@Data
public class ItemFacturaDTO {
    private Integer idProducto;
    private Integer cantidad;
    private double precio;
    private double subtotal;
}
