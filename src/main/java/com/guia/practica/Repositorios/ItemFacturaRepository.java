package com.guia.practica.Repositorios;

import com.guia.practica.Modelos.Factura;
import com.guia.practica.Modelos.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Integer> {
    ItemFactura findByIdItemFactura(Integer id);

    ItemFactura deleteAllByFactura(Factura factura);
}
