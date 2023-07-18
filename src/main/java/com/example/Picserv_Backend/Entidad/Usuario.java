package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(length = 30,name = "id_usuario")
    private int idUsuario;
    @Column(length = 50,unique = true,nullable = false)
    private String correo_electronico;
    @Column(length = 50,nullable = false)
    private String Nombre_usuario;
    @Column(length = 50,nullable = false)
    private String contraseña;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
    @JsonIgnore
    private Cliente cliente;
    @OneToOne(mappedBy = "usuario",cascade=CascadeType.ALL)
    @JsonIgnore
    private Trabajador trabajador;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(int idUsuario, String correo_electronico, String nombre_usuario, String contraseña) {
        this.idUsuario = idUsuario;
        this.correo_electronico = correo_electronico;
        Nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        Nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correo_electronico='" + correo_electronico + '\'' +
                ", Nombre_usuario='" + Nombre_usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", cliente=" + cliente +
                ", trabajador=" + trabajador +
                '}';
    }
}
