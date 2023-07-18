package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "trabajador")
public class Trabajador {

    @Id
    @Column(length = 30)
    private int id_trabajador;
    @OneToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne()
    @JoinColumn(name = "id_Oficio")
    private Oficio oficio;
    @Column(length = 30,nullable = false)
    private String Nombre;
    @Column(length = 30,nullable = false)
    private String Apellido;
    @Column(length = 30,nullable = false)
    private int Edad;
    @Column(length = 30,nullable = false)
    private String Telefono;
    @Column(length = 30,nullable = false)
    private String Sexo;

    @Column(name = "imagen",length = 1000000)
    private String imagen;

    @OneToMany(mappedBy = "trabajador")
    @JsonIgnore
    private Set<Postulados>postulados;

    @OneToMany(mappedBy = "trabajador")
    @JsonIgnore
    private Set<Contratacion>contratacion;


    public Trabajador() {
    }

    public Trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public Trabajador(int id_trabajador, Usuario usuario, Oficio oficio, String nombre, String apellido, int edad, String telefono, String sexo, String imagen) {
        this.id_trabajador = id_trabajador;
        this.usuario = usuario;
        this.oficio = oficio;
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
        Telefono = telefono;
        Sexo = sexo;
        this.imagen = imagen;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oficio getOficio() {
        return oficio;
    }

    public void setOficio(Oficio oficio) {
        this.oficio = oficio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<Postulados> getPostulados() {
        return postulados;
    }

    public void setPostulados(Set<Postulados> postulados) {
        this.postulados = postulados;
    }

    public Set<Contratacion> getContratacion() {
        return contratacion;
    }

    public void setContratacion(Set<Contratacion> contratacion) {
        this.contratacion = contratacion;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                "id_trabajador=" + id_trabajador +
                ", usuario=" + usuario +
                ", oficio=" + oficio +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Edad=" + Edad +
                ", Telefono='" + Telefono + '\'' +
                ", Sexo='" + Sexo + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}

