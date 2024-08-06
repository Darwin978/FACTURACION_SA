package com.guia.practica.Repositorios;

import com.guia.practica.Modelos.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Integer> {
    ItemFactura findByIdItemFactura(Integer id);
}
