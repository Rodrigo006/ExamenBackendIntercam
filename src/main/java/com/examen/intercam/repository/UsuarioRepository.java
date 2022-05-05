package com.examen.intercam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.intercam.dao.UsuarioEntity;

/**
 * Clase Repositorio que permite generar las operaicones de insertar, modificar, consultar y eliminar
 * registros de la tabla usuarios.
 * 
 * @author Rodrigo Rogel Ramirez
 *
 */

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{

}
