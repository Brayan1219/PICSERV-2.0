package com.example.Picserv_Backend.Servicio;

import com.example.Picserv_Backend.Entidad.Oficio;
import com.example.Picserv_Backend.Repositorio.RepositorioOficio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioOficio {

    private RepositorioOficio repositorio;

    public ServicioOficio(RepositorioOficio repositorio){this.repositorio=repositorio;}

    public ArrayList<Oficio> ListarOficio(){
        return (ArrayList<Oficio>) repositorio.findAll();
    }

    public String AgregarOficio(Oficio oficio){
        if (repositorio.findById(oficio.getId_Oficio()).isPresent()){
            return ("El Oficio ya se encuentra registrada");
        }
        else {
            repositorio.save(oficio);
            return ("El Oficio se registo con exito");
        }
    }

    public Oficio BuscarOficio(int id){
        if (repositorio.findById(id).isPresent()){
            return repositorio.findById(id).get();
        }
        else {
            return null;
        }
    }

    public String ActualizarOficio(Oficio ofi){
        if (repositorio.findById(ofi.getId_Oficio()).isPresent()){
            repositorio.save(ofi);
            return "El oficio se actualizo con exito";
        }
        else {
            return "El Oficio no se encuentra en la base de datos";
        }
    }


    public String EliminarOficio(int id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return ("El Oficio se Elimino con exito");
        }
        else {
            return ("El Oficio no se encuentra en la base de datos");
        }
    }

}
