package com.guia.practica.Repositorios;

import com.guia.practica.Modelos.Persona;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByIdPersona(Integer idPersona);
}
