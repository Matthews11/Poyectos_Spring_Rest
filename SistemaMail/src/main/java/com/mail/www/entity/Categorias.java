/**
 * 
 */
package com.mail.www.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author jared
 *
 */
@Entity
@Table(name="categorias")
public class Categorias implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7971924130555401328L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCa;
	
	@NotEmpty
	@Column(nullable = false)
	private String nombre;

	public long getIdCa() {
		return idCa;
	}

	public void setIdCa(int idCa) {
		this.idCa = idCa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
