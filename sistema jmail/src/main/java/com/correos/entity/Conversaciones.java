package com.correos.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "conversaciones")
public class Conversaciones implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String asunto;

    @NotEmpty
    private String descripcion;


    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(unique = true)
    private String envia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuarios IU;

    @NotEmpty
    private String recibe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estados")
    private Estados estados;

    @PrePersist
    public void prePersist() {
        fecha = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
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

    public String getRecibe() {
        return recibe;
    }

    public void setRecibe(String recibe) {
        this.recibe = recibe;
    }

    public String getEnvia() {
        return envia;
    }

    public void setEnvia(String envia) {
        this.envia = envia;
    }

    public Usuarios getIU() {
        return IU;
    }

    public void setIU(Usuarios IU) {
        this.IU = IU;
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }
}

