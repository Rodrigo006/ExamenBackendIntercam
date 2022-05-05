package com.examen.intercam.dao;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.examen.intercam.utils.ComunConstants;

/**
 * Clase Entidad que genera el mapeo de la tabla usuarios para manejar las operaciones 
 * sobre los datos de la tabla.
 * @author Rodrigo Rogel Ramirez
 *
 */

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int 	idUsuario;
	@Column(name="NOMBRE", nullable = false)
	@NotNull(message = ComunConstants.MSG_NOMBRE_VACIO)
	@NotEmpty (message = ComunConstants.MSG_NOMBRE_VACIO)
	private String  nombre;
	@Column(name = "APELLIDO_PATERNO", nullable = false)
	@NotNull(message = ComunConstants.MSG_APELLIDO_PATERNO_VACIO)
	@NotEmpty (message = ComunConstants.MSG_APELLIDO_PATERNO_VACIO)
	private String 	apellidoPaterno;
	@Column(name = "APELLIDO_MATERNO", nullable = false)
	@NotNull(message = ComunConstants.MSG_APELLIDO_MATERNO_VACIO)
	@NotEmpty (message = ComunConstants.MSG_APELLIDO_MATERNO_VACIO)
	private String	apellidoMaterno;
	@Column(name = "FECHA_NACIMIENTO", nullable = false)
	@NotNull(message = ComunConstants.MSG_FECHA_NAC_VACIO)
	@Temporal (TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date	fechaNacimiento;
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "ID_CUENTA")
	private CuentaEntity cuenta;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn (name = "ID_DIRECCION")
	private DireccionEntity direccion;
	
	
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the cuenta
	 */
	public CuentaEntity getCuenta() {
		return cuenta;
	}
	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(CuentaEntity cuenta) {
		this.cuenta = cuenta;
	}
	/**
	 * @return the direccion
	 */
	public DireccionEntity getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}	
}
