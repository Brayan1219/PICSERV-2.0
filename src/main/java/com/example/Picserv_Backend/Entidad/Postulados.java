package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "postulados")
public class Postulados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_postulados;
    @ManyToOne()
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;
    @ManyToOne()
    @JoinColumn(name = "id_trabajador")
    private Trabajador trabajador;
    @Column(name="fecha_postulacion")
    @Temporal(TemporalType.DATE)
    private Date Fecha_postulacion;

    @PrePersist
    public void fechaActual(){
        this.Fecha_postulacion=new Date();
    }

    public Postulados() {
    }

    public Postulados(Servicio servicio, Trabajador trabajador) {
        this.servicio = servicio;
        this.trabajador = trabajador;
    }

    public int getId_postulados() {
        return id_postulados;
    }

    public void setId_postulados(int id_postulados) {
        this.id_postulados = id_postulados;
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

    public Date getFecha_postulacion() {
        return Fecha_postulacion;
    }

    public void setFecha_postulacion(Date fecha_postulacion) {
        Fecha_postulacion = fecha_postulacion;
    }

    @Override
    public String toString() {
        return "Postulados{" +
                "id_postulados=" + id_postulados +
                ", servicio=" + servicio +
                ", trabajador=" + trabajador +
                ", Fecha_postulacion=" + Fecha_postulacion +
                '}';
    }
}
