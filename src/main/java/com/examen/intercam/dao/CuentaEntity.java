package com.examen.intercam.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.examen.intercam.utils.ComunConstants;

/**
 * Clase Entidad que genera el mapeo de la tabla cuentas para manejar las operaciones 
 * sobre los datos de la tabla.
 * @author Rodrigo Rogel Ramirez
 *
 */

@Entity
@Table(name = "cuentas")
public class CuentaEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CUENTA")
	private int 	idCuenta;
	@Column(name = "NUMERO_CUENTA", nullable = false)
	@NotNull (message = ComunConstants.MSG_NUMERO_CUENTA_VACIO)
	@NotEmpty (message = ComunConstants.MSG_NUMERO_CUENTA_VACIO)
	@Size(min = 10, max = 10, message = ComunConstants.MSG_NUMERO_CUENTA_LENGTH)
	private String 	numeroCuenta;
	@Column(name = "INGRESOS", nullable = false)
	@NotNull (message = ComunConstants.MSG_INGRESOS_VACIO)
	@Min (value = 1, message = ComunConstants.MSG_INGRESOS_MIN)
	private float	ingresos;
	
	/**
	 * @return the idCuenta
	 */
	public int getIdCuenta() {
		return idCuenta;
	}
	/**
	 * @param idCuenta the idCuenta to set
	 */
	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}
	/**
	 * @return the numeroCuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	/**
	 * @param numeroCuenta the numeroCuenta to set
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	/**
	 * @return the ingresos
	 */
	public float getIngresos() {
		return ingresos;
	}
	/**
	 * @param ingresos the ingresos to set
	 */
	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}
}
