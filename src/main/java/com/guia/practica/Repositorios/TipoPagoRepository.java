package com.guia.practica.Repositorios;

import com.guia.practica.Modelos.TipoPago;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {
    TipoPago findByIdTipoPago(Integer idTipoPago);
}
