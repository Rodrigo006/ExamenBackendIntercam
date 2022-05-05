package com.examen.intercam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.intercam.dao.DireccionEntity;

/**
 * Clase Repositorio que permite generar las operaicones de insertar, modificar, consultar y eliminar
 * registros de la tabla direccion.
 * 
 * @author Rodrigo Rogel Ramirez
 *
 */

@Repository
public interface DireccionRepository extends JpaRepository<DireccionEntity, Integer>{

}
