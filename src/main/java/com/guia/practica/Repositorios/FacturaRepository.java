package com.guia.practica.Repositorios;

import com.guia.practica.Modelos.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    Factura findByIdFactura(Integer id);
}
