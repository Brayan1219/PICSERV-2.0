package com.example.Picserv_Backend.Servicio;

import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Entidad.Oficio;
import com.example.Picserv_Backend.Entidad.Servicio;
import com.example.Picserv_Backend.Repositorio.RepositorioCliente;
import com.example.Picserv_Backend.Repositorio.RepositorioOficio;
import com.example.Picserv_Backend.Repositorio.RepositorioServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioServicio {

    private RepositorioServicio repositorio;
    private RepositorioCliente RepoClien;
    private RepositorioOficio  RepoOfi;

    public ServicioServicio(RepositorioServicio repositorio, RepositorioCliente repoClien, RepositorioOficio repoOfi) {
        this.repositorio = repositorio;
        RepoClien = repoClien;
        RepoOfi = repoOfi;
    }

    public ArrayList<Servicio>ListarServicio(){return (ArrayList<Servicio>) repositorio.findAll();}

    public Servicio buscarServicioPorId(int idServicio) {
        Optional<Servicio> optionalServicio = repositorio.findById(idServicio);
        return optionalServicio.orElse(null);
    }


    public String AgregarServicio(Servicio servicio,int id_cliente,int id_Oficio){
        if (RepoClien.findById(id_cliente).isPresent() && RepoOfi.findById(id_Oficio).isPresent()){
            Cliente cli=RepoClien.findById(id_cliente).get();
            Oficio ofi=RepoOfi.findById(id_Oficio).get();
            servicio.setCliente(cli);
            servicio.setOficio(ofi);
            servicio.fechaActual();
            repositorio.save(servicio);
            return "Servicio Agregado";
        }else {
            return "El servicio no quedo agregado";
        }

    }

    public List<Servicio> BuscarServicio(Cliente cliente) {
        List<Servicio> servicios = repositorio.findByCliente(cliente);
        if (!servicios.isEmpty()) {
            return servicios;
        } else {
            return null;
        }
    }

    public List<Servicio> BuscarPorOficio(Oficio oficio) {
        List<Servicio> servicios = repositorio.findByOficio(oficio);
        if (!servicios.isEmpty()) {
            return servicios;
        } else {
            return null;
        }
    }

    public String ActualizarServicio(Servicio servicio){
        Optional<Servicio> servicioExistente = repositorio.findById(servicio.getId_servicio());

        if (servicioExistente.isPresent()){
            Servicio servicioActualizado = servicioExistente.get();

            // Actualizar las propiedades del servicio
            servicioActualizado.setTitulo(servicio.getTitulo());
            servicioActualizado.setDescripcion(servicio.getDescripcion());
            servicioActualizado.setPago(servicio.getPago());
            servicioActualizado.setUbicacion(servicio.getUbicacion());
            servicioActualizado.setFecha_fin(servicio.getFecha_fin());

            // Actualizar las llaves foráneas si es necesario
            servicioActualizado.setCliente(servicio.getCliente());
            servicioActualizado.setOficio(servicio.getOficio());

            repositorio.save(servicioActualizado);
            return "El servicio se actualizó exitosamente";
        } else {
            return "El servicio no se puede actualizar";
        }
    }

    public String EliminarServicio(int id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return ("El Servicio se Elimino con exito");
        }
        else {
            return ("El Servicio no se encuentra en la base de datos");
        }
    }

}
