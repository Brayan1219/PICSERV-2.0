package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.ToString;

import java.util.Set;
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(length = 30)
    private int id_cliente;
    @OneToOne()
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @Column(length = 30,nullable = false)
    private String Nombre;
    @Column(length = 30,nullable = false)
    private String Apellido;
    @Column(length = 20,nullable = false)
    private String Telefono;
    @Column(length = 30,nullable = false)
    private int Edad;
    @Column(length = 50,nullable = false)
    private String sexo;
    @Column(name = "imagen",length = 1000000)
    private String imagen;


    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<Servicio>servicio;

    public Cliente() {
    }

    public Cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Cliente(int id_cliente, Usuario usuario, String nombre, String apellido, String telefono, int edad, String sexo, String imagen) {
        this.id_cliente = id_cliente;
        this.usuario = usuario;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Edad = edad;
        this.sexo = sexo;
        this.imagen = imagen;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<Servicio> getServicio() {
        return servicio;
    }

    public void setServicio(Set<Servicio> servicio) {
        this.servicio = servicio;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Edad=" + Edad +
                ", sexo='" + sexo + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }


}
