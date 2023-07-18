package com.example.Picserv_Backend.Servicio;



import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Entidad.Oficio;
import com.example.Picserv_Backend.Entidad.Trabajador;
import com.example.Picserv_Backend.Entidad.Usuario;
import com.example.Picserv_Backend.Repositorio.RepositorioOficio;
import com.example.Picserv_Backend.Repositorio.RepositorioTrabajador;
import com.example.Picserv_Backend.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioTrabajador {

    private RepositorioTrabajador repositorio;
    private RepositorioUsuario RepoUsu;
    private RepositorioOficio RepOficio;

    public ServicioTrabajador(RepositorioTrabajador repositorio, RepositorioUsuario repoUsu, RepositorioOficio repOficio) {
        this.repositorio = repositorio;
        RepoUsu = repoUsu;
        RepOficio = repOficio;
    }

    public ArrayList<Trabajador> ListarTrabajador(){
        return (ArrayList<Trabajador>) repositorio.findAll();
    }

    public String AgregarTrabajador(Trabajador trabajador, int id_usuario,int id_oficio){
        if (RepoUsu.findById(id_usuario).isPresent() && RepOficio.findById(id_oficio).isPresent()){
            Usuario usu=RepoUsu.findById(id_usuario).get();
            Oficio ofi=RepOficio.findById(id_oficio).get();
            trabajador.setUsuario(usu);
            trabajador.setOficio(ofi);
            repositorio.save(trabajador);
            return "Trabajador Registrado";
        }
        else {
            return "El Trabajador no se registro";
        }
    }

    public Trabajador buscarTrabajador(int id) {
        Optional<Trabajador> optionalTrabajador = repositorio.findById(id);
        return optionalTrabajador.orElse(null);
    }

    public String ActualizarTrabajador(Trabajador tra){
        if (repositorio.findById(tra.getId_trabajador()).isPresent()){
            repositorio.save(tra);
            return "El Trabajador se actualizo exitosamente";
        }
        else {
            return "El Trabajador no se encuentra en la base de datos";
        }
    }


    public String EliminarTrabajador(int id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return ("El Trabajador se elimino con exito");
        }
        else {
            return ("El Trabajador no esta en la base de datos");
        }
    }

}
