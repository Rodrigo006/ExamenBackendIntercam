package com.examen.intercam.service;

import java.util.List;
import java.util.Optional;

import com.examen.intercam.dao.UsuarioEntity;

/**
 * Clase servicio que define los metodos con las operaciones disponibles 
 * para las peticiones que puede generar el controlador de usuarios.
 * 
 * @author Rodrigo Rogel Ramirez
 *
 */
public interface UsuarioService {

	/**
	 * Método encargado de hacer el regisrto de un usuario.
	 * 
	 * @param usuario Objeto que contiene la información a registrar
	 * @return Retorna la entidad persistida incluyendo el id generado
	 */
	UsuarioEntity guardarUsuario(UsuarioEntity usuario);
	
	/**
	 * Método encargado de modificar un usuario.
	 * @param usuarioModificado contiene la información a actualizar
	 * @return Retorna la entidad modificada
	 */
	UsuarioEntity modificarUsuario(UsuarioEntity usuarioModificado);
	
	/**
	 * Método encargado de consultar un usuario por medio de su Id
	 * @param idUsuario Identificador del usuario a consultar
	 * @return retorna una entidad de tipo UsuarioEntity si encuentra un resultado si no regresa el objeto vacio
	 */
	Optional<UsuarioEntity> consultaUsuario(int idUsuario);
	
	/**
	 * Método encargado de listar todos los usuarios que hay en la tabla usuarios
	 * @return Retorna una lista con todos los usuarios
	 */
	List<UsuarioEntity> consultarUsuarios();
	
	/**
	 * Método encargado de eliminar un usuario por medio de su Id
	 * @param idUsuario Identificador del usuario a eliminar
	 * @return retorna true si se elimino correctamente o false si no se pudo eliminar
	 */
	boolean elimarUsuario(int idUsuario);
}
