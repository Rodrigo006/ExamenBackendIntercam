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

import com.examen.intercam.dao.DireccionEntity;
import com.examen.intercam.service.DireccionService;

/**
 * Clase controlador que se encarga de procesar las peticiones que estan
 * relacionadas a las direcciones.
 * 
 * @author Rodrigo Rogel Ramierz
 *
 */
@RestController
@RequestMapping("/api-crud")
public class DireccionController {

	@Autowired
	private DireccionService direccionService;
	
	/**
	 * Método encargado de procesar la petición para registrar una nueva dirección
	 * 
	 * @param direccion Objeto que contiene la información a registrar
	 * @return Retorna la entidad que fue registrada
	 */
	@PostMapping("/direcciones")
	public ResponseEntity<DireccionEntity> registrarDireccion(@RequestBody DireccionEntity direccion){
		return new ResponseEntity<DireccionEntity>(direccionService.guardarDireccion(direccion), HttpStatus.CREATED);
	}
	
	/**
	 * Método encargado de procesar la petición para modificar una dirección existente.
	 * @param idDireccion Identificador de la dirección a modificar
	 * @param direccionModificada Objeto que contiene la infromación a actualizar
	 * @return Retorna la entidad que fue modificada o el estatus NOT_FOUND si no se encuentra el id de la dirección
	 */
	@PutMapping("/direcciones/{idDireccion}")
	public ResponseEntity<DireccionEntity> modificarDireccion(@PathVariable("idDireccion") int idDireccion, @RequestBody DireccionEntity direccionModificada){
		Optional<DireccionEntity> usuario=  direccionService.consultaDireccion(idDireccion);
		if(!usuario.isEmpty()) {
			direccionModificada.setIdDireccion(idDireccion);
			return new ResponseEntity<DireccionEntity>(direccionService.modificarDireccion(direccionModificada), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método que lista todas las direcciones que tiene la tabla direccion
	 * @return Retorna la lista que contiene a las direcciones
	 */
	@GetMapping("/direcciones")
	public ResponseEntity<List<DireccionEntity>> consultarDirecciones(){
		return new ResponseEntity<List<DireccionEntity>>(direccionService.consultarDirecciones(), HttpStatus.OK);
	}
	
	/**
	 * Método que se encarga de consultar una dirección por su Id
	 * @param idDireccion Identificador de la dirección a consultar
	 * @return Retorna la entidad de dirección en caso de encontrar un registro o NOT_FOUND si no existe ningun registro con ese id
	 */
	@GetMapping("/direcciones/{idDireccion}")
	public ResponseEntity<Optional<DireccionEntity>> consultaDireccion(@PathVariable(name = "idDireccion") int idDireccion){
		Optional<DireccionEntity> usuario = direccionService.consultaDireccion(idDireccion);
		if(!usuario.isEmpty()) {
			return new ResponseEntity<Optional<DireccionEntity>>(usuario, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	/**
	 * Método encargado de eliminar una dirección por medio de su id
	 * @param idDireccion Identificador de la dirección a eliminar
	 * @return Retorna estatus OK si se elimino corretamente o NOT_FOUND si no se encuentra la dirección a eliminar
	 */
	@DeleteMapping("/direcciones/{idDireccion}")
	public ResponseEntity<Void> eliminarDireccion(@PathVariable(name = "idDireccion") int idDireccion){
		boolean respuesta = direccionService.elimarDireccion(idDireccion);
		if(respuesta) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
