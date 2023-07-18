package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contratacion")
public class Contratacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_contratacion;
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
    @ManyToOne
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;
    @Column(name="fecha_contratacion")
    @Temporal(TemporalType.DATE)
    private Date Fecha_contratacion;

    @PrePersist
    public void fechaActual(){
        this.Fecha_contratacion=new Date();
    }


    public Contratacion() {
    }

    public Contratacion(Servicio servicio, Trabajador trabajador) {
        this.servicio = servicio;
        this.trabajador = trabajador;
    }

    public int getId_contratacion() {
        return id_contratacion;
    }

    public void setId_contratacion(int id_contratacion) {
        this.id_contratacion = id_contratacion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Date getFecha_contratacion() {
        return Fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        Fecha_contratacion = fecha_contratacion;
    }

    @Override
    public String toString() {
        return "Contratacion{" +
                "id_contratacion=" + id_contratacion +
                ", servicio=" + servicio +
                ", trabajador=" + trabajador +
                ", Fecha_contratacion=" + Fecha_contratacion +
                '}';
    }
}
