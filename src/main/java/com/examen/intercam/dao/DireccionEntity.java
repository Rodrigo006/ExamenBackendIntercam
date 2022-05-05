package com.examen.intercam.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.examen.intercam.utils.ComunConstants;

/**
 * Clase Entidad que genera el mapeo de la tabla direccion para manejar las operaciones 
 * sobre los datos de la tabla.
 * @author Rodrigo Rogel Ramirez
 *
 */
@Entity
@Table(name = "direccion")
public class DireccionEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DIRECCION")
	private int 	idDireccion;
	@Column(name = "CODIGO_POSTAL", nullable = false)
	@NotNull (message = ComunConstants.MSG_CODIGO_POSTAL_VACIO)
	@NotEmpty (message = ComunConstants.MSG_CODIGO_POSTAL_VACIO)
	@Size(min = 6, max = 6, message = ComunConstants.MSG_CODIGO_POSTAL_LENGTH)
	private String 	codigoPostal;
	@Column(name = "ESTADO", nullable = false)
	@NotNull (message = ComunConstants.MSG_ESTADO_VACIO)
	@NotEmpty (message = ComunConstants.MSG_ESTADO_VACIO)
	private String 	estado;
	
	/**
	 * @return the idDireccion
	 */
	public int getIdDireccion() {
		return idDireccion;
	}
	/**
	 * @param idDireccion the idDireccion to set
	 */
	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}
	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
