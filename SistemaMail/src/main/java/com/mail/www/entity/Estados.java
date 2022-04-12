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
@Table(name="estados")
public class Estados implements Serializable{

	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -4235254829641766002L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idE;
	
	@NotEmpty
	@Column(nullable = false)
	private String nombre;

	public long getIdE() {
		return idE;
	}

	public void setIdE(int idE) {
		this.idE = idE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

	
}
