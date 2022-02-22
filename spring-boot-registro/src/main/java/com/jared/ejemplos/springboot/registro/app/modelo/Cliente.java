package com.jared.ejemplos.springboot.registro.app.modelo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
//import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull; 

//import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.jared.ejemplos.springboot.registro.app.models.domain.Role;
import com.jared.ejemplos.springboot.registro.app.validation.IdRegex;
import com.jared.ejemplos.springboot.registro.app.validation.Requerido;

@Component
public class Cliente {

	@IdRegex 
	private String id;
	
	//@NotEmpty
	private String nombre;
	
	//@NotEmpty
	@Requerido
	private String apellido;
	
	@NotNull
	@Min(5)
	@Max(500)
	private Integer edad;
	
	@NotEmpty
	private String estado;
	
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private String profesion;
	
	@NotNull
	private Pais pais;
	
	@NotNull
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	
//	@FutureOrPresent
	private Date fechaNacimiento;

	@NotEmpty
	private List <Role> roles ;
	
	private Boolean habilitar; 
	@NotEmpty
	private String genero;
	
	private String valorSecreto;
	
	
 
	public String getValorSecreto() {
		return valorSecreto;
	}

	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	
	
}
