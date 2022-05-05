package com.examen.intercam.service;

import java.util.List;
import java.util.Optional;

import com.examen.intercam.dao.CuentaEntity;

/**
 * Clase servicio que define los metodos con las operaciones disponibles 
 * para las peticiones que puede generar el controlador de cuentas.
 * 
 * @author Rodrigo Rogel Ramirez
 *
 */
public interface CuentaService {
	
	/**
	 * Método encargado de hacer el regisrto de una cuenta.
	 * 
	 * @param cuenta Objeto que contiene la información a registrar
	 * @return Retorna la entidad persistida incluyendo el id generado
	 */
	CuentaEntity guardarCuenta(CuentaEntity cuenta);
	
	/**
	 * Método encargado de modificar una cuenta
	 * @param cuentaModificada contiene la información a actualizar
	 * @return Retorna la entidad modificada
	 */
	CuentaEntity modificarCuenta(CuentaEntity cuentaModificada);
	
	/**
	 * Método encargado de consultar una cuenta por medio de su Id
	 * @param idCuenta Identificador de la cuenta a consultar
	 * @return retorna una entidad de tipo CuentaEntity si encuentra un resultado si no regresa el objeto vacio
	 */
	Optional<CuentaEntity> consultaCuenta(int idCuenta);
	
	/**
	 * Método encargado de listar todas las cuentas que hay en la tabla cuentas
	 * @return Retorna una lista con todas la cuentas
	 */
	List<CuentaEntity> consultarCuentas();
	
	/**
	 * Método encargado de eliminar una cuenta por medio de su Id
	 * @param idCuenta Identificador de la cuenta a eliminar
	 * @return retorna true si se elimino correctamente o false si no se pudo eliminar
	 */
	boolean elimarCuenta(int idCuenta);
}
