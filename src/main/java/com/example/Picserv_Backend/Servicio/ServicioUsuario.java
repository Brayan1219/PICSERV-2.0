package com.example.Picserv_Backend.Servicio;


import com.example.Picserv_Backend.Entidad.Servicio;
import com.example.Picserv_Backend.Entidad.Usuario;

import com.example.Picserv_Backend.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioUsuario {

    private RepositorioUsuario repositorio;

    public ServicioUsuario(RepositorioUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public ArrayList<Usuario> ListarUsuario(){
        return (ArrayList<Usuario>) repositorio.findAll();
    }

    public String AgregarUsuario(Usuario usuario){
        if (repositorio.findById(usuario.getIdUsuario()).isPresent()){
            return ("El Usuario Ya se encuentra registrado");
        }
        else {
            repositorio.save(usuario);
            return ("El usuario se registro con exito");
        }
    }

    public Usuario BuscarUsuario(int id){
        if (repositorio.findById(id).isPresent()){
            return repositorio.findById(id).get();
        }
        else {
            return null;
        }
    }

    public String ActualizarUsuario(Usuario usu){
        if (repositorio.findById(usu.getIdUsuario()).isPresent()){
            repositorio.save(usu);
            return "El Usuario se actualizo exitosamente";
        }
        else {
            return "El usuario no se encuentra en la base de datos";
        }
    }




    public String EliminarUsuario(int id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return ("El usuario se elimino con exito");
        }
        else {
            return ("El usuario no esta en la base de datos");
        }
    }

    public String login(int idUsuario, String contraseña) {
        Usuario usuario = repositorio.findByIdUsuarioAndContraseña(idUsuario,contraseña);
        if (usuario != null) {
            if (usuario.getCliente() != null) {
                return "cliente";
            } else if (usuario.getTrabajador() != null) {
                return "trabajador";
            }
        }
        return null;
    }

}
