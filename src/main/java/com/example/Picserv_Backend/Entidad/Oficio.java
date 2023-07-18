package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "oficio")
public class Oficio {

    @Id
    @Column(length = 30)
    private int id_Oficio;
    @Column(length = 30, nullable = false)
    private String Nombre;
    @Column(length = 120, nullable = false)
    private String Descripcion;

    @OneToMany(mappedBy = "oficio")
    @JsonIgnore
    private Set<Trabajador>trabajador;

    @OneToMany(mappedBy = "oficio")
    @JsonIgnore
    private Set<Servicio>servicio;

    public Oficio() {
    }

    public Oficio(int id_Oficio) {
        this.id_Oficio = id_Oficio;
    }

    public Oficio(int id_Oficio, String nombre, String descripcion) {
        this.id_Oficio = id_Oficio;
        Nombre = nombre;
        Descripcion = descripcion;
    }

    public int getId_Oficio() {
        return id_Oficio;
    }

    public void setId_Oficio(int id_Oficio) {
        this.id_Oficio = id_Oficio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Set<Trabajador> getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Set<Trabajador> trabajador) {
        this.trabajador = trabajador;
    }

    public Set<Servicio> getServicio() {
        return servicio;
    }

    public void setServicio(Set<Servicio> servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Oficio{" +
                "id_Oficio=" + id_Oficio +
                ", Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                '}';
    }
}
