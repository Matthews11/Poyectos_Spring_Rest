/**
 * 
 */
package com.mail.www.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="chats")
public class Chats implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1643559626421167855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCh;
	
	@NotBlank
	@Column(nullable = false)
	private String titulo;
	
	@NotBlank
	@Column(nullable = false)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@NotBlank
	@Email
	private String mailE;
	
	@NotBlank
	@Email
	private String mailR;
	
	 
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private String categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario")
	private Usuarios usuario;
 
	@PrePersist
	 public void prePersist() {
		fecha = new Date();
   }
	 
	 
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getMailE() {
		return mailE;
	}

	public void setMailE(String mailE) {
		this.mailE = mailE;
	}

	public String getMailR() {
		return mailR;
	}

	public void setMailR(String mailR) {
		this.mailR = mailR;
	}

	 

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	 

	public long getIdCh() {
		return idCh;
	}


	public void setIdCh(long idCh) {
		this.idCh = idCh;
	}


	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
}
