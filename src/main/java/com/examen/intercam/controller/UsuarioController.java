package com.examen.intercam.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.intercam.dao.UsuarioEntity;
import com.examen.intercam.service.UsuarioService;

/**
 * Clase controlador que se encarga de procesar las peticiones que estan
 * relacionadas a los usuarios.
 * 
 * @author Rodrigo Rogel Ramierz
 *
 */
@RestController
@RequestMapping("/api-crud")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Método encargado de procesar la petición para registrar un nuevo usuario
	 * 
	 * @param usuario Objeto que contiene la información a registrar
	 * @return Retorna la entidad que fue registrada
	 */
	@PostMapping("/usuarios")
	public ResponseEntity<UsuarioEntity> registrarUsuario(@RequestBody UsuarioEntity usuario){
		return new ResponseEntity<UsuarioEntity>(usuarioService.guardarUsuario(usuario), HttpStatus.CREATED);
	}
	
	/**
	 * Método encargado de procesar la petición para modificar un usuario existente.
	 * @param idUsuario Identificador del usuario a modificar
	 * @param usuarioModificado Objeto que contiene la infromación a actualizar
	 * @return Retorna la entidad que fue modificada o el estatus NOT_FOUND si no se encuentra el id del usuario
	 */
	@PutMapping("/usuarios/{idUsuario}")
	public ResponseEntity<UsuarioEntity> modificarUsuario(@PathVariable("idUsuario") int idUsuario, @RequestBody UsuarioEntity usuarioModificado){
		Optional<UsuarioEntity> usuario=  usuarioService.consultaUsuario(idUsuario);
		if(!usuario.isEmpty()) {
			usuarioModificado.setIdUsuario(idUsuario);
			return new ResponseEntity<UsuarioEntity>(usuarioService.modificarUsuario(usuarioModificado), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método que lista todos los usuarios que tiene la tabla usuarios
	 * @return Retorna la lista que contiene a los usuarios
	 */
	@GetMapping("/usuarios")
	public ResponseEntity<List<UsuarioEntity>> consultarUsuarios(){
		return new ResponseEntity<List<UsuarioEntity>>(usuarioService.consultarUsuarios(), HttpStatus.OK);
	}
	
	/**
	 * Método que se encarga de consultar un usuario por su Id
	 * @param idUsuario Identificador del usuario a consultar
	 * @return Retorna la entidad de usuario en caso de encontrar un registro o NOT_FOUND si no existe ningun registro con ese id
	 */
	@GetMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Optional<UsuarioEntity>> consultaUsuario(@PathVariable(name = "idUsuario") int idUsuario){
		Optional<UsuarioEntity> usuario = usuarioService.consultaUsuario(idUsuario);
		if(!usuario.isEmpty()) {
			return new ResponseEntity<Optional<UsuarioEntity>>(usuario, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	/**
	 * Método encargado de eliminar un usuario por medio de su id
	 * @param idUsuario Identificador del usuario a eliminar
	 * @return Retorna estatus OK si se elimino corretamente o NOT_FOUND si no se encuentra el usuario a eliminar
	 */
	@DeleteMapping("/usuarios/{idUsuario}")
	public ResponseEntity<Void> eliminarUsuario(@PathVariable(name = "idUsuario") int idUsuario){
		boolean respuesta = usuarioService.elimarUsuario(idUsuario);
		if(respuesta) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
