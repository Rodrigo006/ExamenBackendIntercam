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

import com.examen.intercam.dao.CuentaEntity;
import com.examen.intercam.service.CuentaService;

/**
 * Clase controlador que se encarga de procesar las peticiones que estan
 * relacionadas a las Cuentas.
 * 
 * @author Rodrigo Rogel Ramierz
 *
 */
@RestController
@RequestMapping("/api-crud")
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;
	
	/**
	 * Método encargado de procesar la petición para registrar una nueva cuenta
	 * 
	 * @param cuenta Objeto que contiene la información a registrar
	 * @return Retorna la entidad que fue registrada
	 */
	@PostMapping("/cuentas")
	public ResponseEntity<CuentaEntity> registrarCuenta(@RequestBody CuentaEntity cuenta){
		return new ResponseEntity<CuentaEntity>(cuentaService.guardarCuenta(cuenta), HttpStatus.CREATED);
	}
	
	/**
	 * Método encargado de procesar la petición para modificar una cuenta existente.
	 * @param idCuenta Identificador de la cuenta a modificar
	 * @param cuentaModificada Objeto que contiene la infromación a actualizar
	 * @return Retorna la entidad que fue modificada o el estatus NOT_FOUND si no se encuentra el id de la cuenta
	 */
	@PutMapping("/cuentas/{idCuenta}")
	public ResponseEntity<CuentaEntity> modificarCuenta(@PathVariable("idCuenta") int idCuenta, @RequestBody CuentaEntity cuentaModificada){
		Optional<CuentaEntity> cuenta=  cuentaService.consultaCuenta(idCuenta);
		if(!cuenta.isEmpty()) {
			cuentaModificada.setIdCuenta(idCuenta);
			return new ResponseEntity<CuentaEntity>(cuentaService.modificarCuenta(cuentaModificada), HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método que lista todas las cuentas que tiene la tabla cuentas
	 * @return Retorna la lista que contiene a las cuentas
	 */
	@GetMapping("/cuentas")
	public ResponseEntity<List<CuentaEntity>> consultarCuentas(){
		return new ResponseEntity<List<CuentaEntity>>(cuentaService.consultarCuentas(), HttpStatus.OK);
	}
	
	/**
	 * Método que se encarga de consultar una cuenta por su Id
	 * @param idCuenta Identificador de la cuenta a consultar
	 * @return Retorna la entidad de cuenta en caso de encontrar un registro o NOT_FOUND si no existe ningun registro con ese id
	 */
	@GetMapping("/cuentas/{idCuenta}")
	public ResponseEntity<Optional<CuentaEntity>> consultaCuenta(@PathVariable(name = "idCuenta") int idCuenta){
		Optional<CuentaEntity> cuenta = cuentaService.consultaCuenta(idCuenta);
		if(!cuenta.isEmpty()) {
			return new ResponseEntity<Optional<CuentaEntity>>(cuenta, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Método encargado de eliminar una cuenta por medio de su id
	 * @param idCuenta Identificador de la cuenta a eliminar
	 * @return Retorna estatus OK si se elimino corretamente o NOT_FOUND si no se encuentra la cuenta a eliminar
	 */
	@DeleteMapping("/cuentas/{idCuenta}")
	public ResponseEntity<Void> eliminarCuenta(@PathVariable(name = "idCuenta") int idCuenta){
		boolean respuesta = cuentaService.elimarCuenta(idCuenta);
		if(respuesta) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
