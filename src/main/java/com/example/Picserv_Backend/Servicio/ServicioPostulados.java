package com.example.Picserv_Backend.Servicio;

import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Entidad.Postulados;
import com.example.Picserv_Backend.Entidad.Servicio;
import com.example.Picserv_Backend.Entidad.Trabajador;
import com.example.Picserv_Backend.Repositorio.RepositorioPostulados;
import com.example.Picserv_Backend.Repositorio.RepositorioServicio;
import com.example.Picserv_Backend.Repositorio.RepositorioTrabajador;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ServicioPostulados {

    private RepositorioPostulados repositorio;
    private RepositorioServicio RepoSer;
    private RepositorioTrabajador RepoTra;

    public ServicioPostulados(RepositorioPostulados repositorio, RepositorioServicio repoSer, RepositorioTrabajador repoTra) {
        this.repositorio = repositorio;
        RepoSer = repoSer;
        RepoTra = repoTra;
    }

    public ArrayList<Postulados>ListarPostulados(){
        return (ArrayList<Postulados>) repositorio.findAll();
    }

    public String AgregarPostulados(int id_trabajador,int id_servicio){
        Postulados pos=new Postulados();
        if (RepoTra.findById(id_trabajador).isPresent() && RepoSer.findById(id_servicio).isPresent()){
            Trabajador tra= RepoTra.findById(id_trabajador).get();
            Servicio ser=RepoSer.findById(id_servicio).get();
            pos.setServicio(ser);
            pos.setTrabajador(tra);
            pos.fechaActual();
            repositorio.save(pos);
            return "su postulacion ha sido exitosa";
        }
        else {
            return "error en la postulacion";
        }
    }

    public List<Postulados> BuscarPostulados(Trabajador trabajador) {
        List<Postulados> postulados = repositorio.findByTrabajador(trabajador);
        if (!postulados.isEmpty()) {
            return postulados;
        } else {
            return null;
        }
    }


    public void EliminarPostulados(Trabajador trabajador) {
        List<Postulados> postulados = repositorio.findByTrabajador(trabajador);
        Iterator<Postulados> iterator = postulados.iterator();
        while (iterator.hasNext()) {
            Postulados postulados1 = iterator.next();
            repositorio.delete(postulados1);
            System.out.println("postulado eliminado: " + postulados1.getId_postulados());
        }
        System.out.println("Eliminación de postulado completada.");
    }


}
