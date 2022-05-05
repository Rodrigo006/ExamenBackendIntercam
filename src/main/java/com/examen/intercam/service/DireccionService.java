package com.examen.intercam.service;

import java.util.List;
import java.util.Optional;


import com.examen.intercam.dao.DireccionEntity;

/**
 * Clase servicio que define los metodos con las operaciones disponibles 
 * para las peticiones que puede generar el controlador de direcciones.
 * 
 * @author Rodrigo Rogel Ramirez
 *
 */
public interface DireccionService {
	
	/**
	 * Método encargado de hacer el regisrto de una dirección.
	 * 
	 * @param direccion Objeto que contiene la información a registrar
	 * @return Retorna la entidad persistida incluyendo el id generado
	 */
	DireccionEntity guardarDireccion(DireccionEntity direccion);
	
	/**
	 * Método encargado de modificar una dirección.
	 * @param direccionModificada contiene la información a actualizar
	 * @return Retorna la entidad modificada
	 */
	DireccionEntity modificarDireccion(DireccionEntity direccionModificada);
	
	/**
	 * Método encargado de consultar una dirección por medio de su Id
	 * @param idDireccion Identificador de la dirección a consultar
	 * @return retorna una entidad de tipo DireccionEntity si encuentra un resultado si no regresa el objeto vacio
	 */
	Optional<DireccionEntity> consultaDireccion(int idDireccion);
	
	/**
	 * Método encargado de listar todas las direcciones que hay en la tabla direcciones
	 * @return Retorna una lista con todas la direcciones
	 */
	List<DireccionEntity> consultarDirecciones();
	
	/**
	 * Método encargado de eliminar una dirección por medio de su Id
	 * @param idDireccion Identificador de la dirección a eliminar
	 * @return retorna true si se elimino correctamente o false si no se pudo eliminar
	 */
	boolean elimarDireccion(int idDireccion);
}
