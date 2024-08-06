package com.guia.practica.Repositorios;

import com.guia.practica.Modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findByIdProducto(Integer idProducto);
}
