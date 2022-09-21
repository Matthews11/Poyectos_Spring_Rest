package com.biblioteca.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="alquileres")
public class Alquiler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7449821535435573910L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDateTime fechaSalida;
	
	@Column(nullable = false)
	private LocalDateTime fechaEntrada;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY
			,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="libro_id", foreignKey = @ForeignKey(name="FK_ALIBRO_Id"))
	private Libro libro;
	
	@ManyToOne(optional = true, fetch=FetchType.LAZY,
			cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="lector_id",foreignKey = @ForeignKey(name="FK_ALECTOR_Id"))
	private Lector lector;
	
	@PrePersist
	void fecha() {
		this.fechaSalida=LocalDateTime.now();
		this.fechaEntrada=LocalDateTime.now();
	}
	
	
	public Alquiler() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Lector getLector() {
		return lector;
	}


	public void setLector(Lector lector) {
		this.lector = lector;
	}


	@Override
	public String toString() {
		return "Alquiler [id=" + id + ", fechaSalida=" + fechaSalida + ", fechaEntrada=" + fechaEntrada + ", libro="
				+ libro + ", lector=" + lector + "]";
	}
	
	
	
}
