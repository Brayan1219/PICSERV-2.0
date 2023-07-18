package com.example.Picserv_Backend.Servicio;

import com.example.Picserv_Backend.Entidad.Contratacion;
import com.example.Picserv_Backend.Entidad.Postulados;
import com.example.Picserv_Backend.Entidad.Servicio;
import com.example.Picserv_Backend.Entidad.Trabajador;
import com.example.Picserv_Backend.Repositorio.RepositorioContratacion;
import com.example.Picserv_Backend.Repositorio.RepositorioServicio;
import com.example.Picserv_Backend.Repositorio.RepositorioTrabajador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioContratacio {

    private RepositorioContratacion repositorio;
    private RepositorioTrabajador RepoTra;

    private RepositorioServicio RepoSer;

    public ServicioContratacio(RepositorioContratacion repositorio, RepositorioTrabajador repoTra, RepositorioServicio repoSer) {
        this.repositorio = repositorio;
        RepoTra = repoTra;
        RepoSer = repoSer;
    }

    public ArrayList<Contratacion> ListarContratacion(){
        return (ArrayList<Contratacion>) repositorio.findAll();
    }

    public String AgregarContratacion(int id_trabajador,int id_servicio){
        Contratacion con=new Contratacion();
        if (RepoTra.findById(id_trabajador).isPresent() && RepoSer.findById(id_servicio).isPresent()){
            Trabajador tra= RepoTra.findById(id_trabajador).get();
            Servicio ser=RepoSer.findById(id_servicio).get();
            con.setServicio(ser);
            con.setTrabajador(tra);
            con.fechaActual();
            repositorio.save(con);
            return "su Contratacion ha sido exitosa";
        }
        else {
            return "error en la postulacion";
        }
    }

    public List<Contratacion> BuscarContratacion(Trabajador trabajador) {
        List<Contratacion> contratacion = repositorio.findByTrabajador(trabajador);
        if (!contratacion.isEmpty()) {      //falta explicarlo
            return contratacion;
        } else {
            return null;
        }
    }
}
