/**
 * 
 */
package com.mail.www.entity;

import java.io.Serializable;
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author jared
 *
 */

@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5403106740919442136L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idU;
	
	@NotBlank
	@Column(nullable = false)
	private String nombre;
	
	@NotBlank
	@Column(nullable = false)
	private String apellido;
	
	@Email
	@NotBlank
	@Column(unique = true, nullable = false)
	private String mail;
	
	@NotBlank
	@Column(nullable = false)
	private String genero;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaN;
	
	@Column(nullable= false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechaC;
	
	@NotBlank
	@Column(nullable = false)
	private String contrasena;
	

	@Column(nullable=false)
	private String role;
	
	@PrePersist
	 public void prePersist() {
        fechaC = new Date();
    }

	 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechaN() {
		return fechaN;
	}

	public void setFechaN(Date fechaN) {
		this.fechaN = fechaN;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setIdU(long idU) {
		this.idU = idU;
	}


	public long getIdU() {
		return idU;
	}
	
	
	 
 
	
}
