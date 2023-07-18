package com.example.Picserv_Backend.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;
    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne()
    @JoinColumn(name = "id_Oficio")
    private Oficio oficio;
    @Column(length = 30,nullable = false)
    private String Titulo;
    @Column(length = 120,nullable = false)
    private String Descripcion;
    @Column(length = 30,nullable = false)
    private Float Pago;
    @Column(length = 30,nullable = false)
    private String Ubicacion;
    @Column(name="fecha")
    @Temporal(TemporalType.DATE)
    private Date Fecha_publicacion;
    @Column(name="fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date Fecha_fin;

    @PrePersist
    public void fechaActual(){
        this.Fecha_publicacion=new Date();
    }

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private Set<Postulados>postulados;

    @OneToMany(mappedBy = "servicio")
    @JsonIgnore
    private Set<Contratacion>contratacion;

    public Servicio() {
    }

    public Servicio(Cliente cliente, Oficio oficio, String titulo, String descripcion, Float pago, String ubicacion, Date fecha_fin) {
        this.cliente = cliente;
        this.oficio = oficio;
        Titulo = titulo;
        Descripcion = descripcion;
        Pago = pago;
        Ubicacion = ubicacion;
        Fecha_fin = fecha_fin;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Oficio getOficio() {
        return oficio;
    }

    public void setOficio(Oficio oficio) {
        this.oficio = oficio;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Float getPago() {
        return Pago;
    }

    public void setPago(Float pago) {
        Pago = pago;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public Date getFecha_publicacion() {
        return Fecha_publicacion;
    }

    public void setFecha_publicacion(Date fecha_publicacion) {
        Fecha_publicacion = fecha_publicacion;
    }

    public Date getFecha_fin() {
        return Fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        Fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id_servicio=" + id_servicio +
                ", cliente=" + cliente +
                ", oficio=" + oficio +
                ", Titulo='" + Titulo + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Pago=" + Pago +
                ", Ubicacion='" + Ubicacion + '\'' +
                ", Fecha_publicacion=" + Fecha_publicacion +
                ", Fecha_fin=" + Fecha_fin +
                '}';
    }
}
