package com.biblioteca.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libro implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2000763030596170631L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 90)
	private String titulo;
	
	@Column(nullable = false, length = 90)
	private String idioma;
	
	@Column(nullable = false, length = 90)
	private String paginas;
	
	@Column(nullable = false, length = 90)
	private String descripcion;
	
	@Column(nullable = false, length = 90)
	private String portada;
	
	@Column(nullable = false)
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "libro",fetch = FetchType.LAZY)
	private List<Alquiler> Alquileres;
	
	@ManyToOne(optional = true,fetch = FetchType.LAZY ,
			cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name="autor_id",foreignKey = @ForeignKey(name="FK_LAUTOR_Id"))
	private Autor autor;
	
	@ManyToOne(optional = true,  fetch = FetchType.LAZY,
			cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "categoria_id", foreignKey = @ForeignKey(name="FK_LCATEGORIA_Id"))
	private Categoria categoria;
	
	@ManyToOne(optional = true, fetch=FetchType.LAZY,
		cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinColumn(name = "editorial_id", foreignKey = @ForeignKey(name="FK_LEDITORIAL_Id"))
	private Editorial editorial;
	
	@PrePersist
	void persistirFecha() {
		this.fecha=LocalDateTime.now();
	}
	
	public Libro() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPaginas() {
		return paginas;
	}

	public void setPaginas(String paginas) {
		this.paginas = paginas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<Alquiler> getAlquileres() {
		return Alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		Alquileres = alquileres;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", idioma=" + idioma + ", paginas=" + paginas
				+ ", descripcion=" + descripcion + ", portada=" + portada + ", fecha=" + fecha + ", Alquileres="
				+ Alquileres + ", autor=" + autor + ", categoria=" + categoria + ", editorial=" + editorial + "]";
	}
	
	
	
}
