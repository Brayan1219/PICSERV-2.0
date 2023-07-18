package com.example.Picserv_Backend.Servicio;

import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Entidad.Usuario;
import com.example.Picserv_Backend.Repositorio.RepositorioCliente;
import com.example.Picserv_Backend.Repositorio.RepositorioUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicioCliente {

    private RepositorioCliente repositorio;

    private RepositorioUsuario repoUsu;

    public ServicioCliente(RepositorioCliente repositorio, RepositorioUsuario repoUsu) {
        this.repositorio = repositorio;
        this.repoUsu = repoUsu;
    }

    public ArrayList<Cliente> ListarCLiente(){
        return (ArrayList<Cliente>) repositorio.findAll();
    }

    public String AgregarCliente(Cliente cliente,int id_usuario){
        if (repoUsu.findById(id_usuario).isPresent()){
            Usuario usu=repoUsu.findById(id_usuario).get();
            cliente.setUsuario(usu);
            repositorio.save(cliente);
            return "Cliente Registrado";
        }
        else {
            return "El Cliente no se registro";
        }
    }

    public Cliente BuscarCliente(int id){
        if (repositorio.findById(id).isPresent()){
            return repositorio.findById(id).get();
        }
        else {
            return null;
        }
    }

    public String ActualizarCliente(Cliente cli){
        if (repositorio.findById(cli.getId_cliente()).isPresent()){
            repositorio.save(cli);
            return "El cliente se actualizo exitosamente";
        }
        else {
            return "El cliente no se encuentra en la base de datos";
        }
    }

    public String Actualizarcli(Cliente cli){
        Optional<Cliente> clienteExistente = repositorio.findById(cli.getId_cliente());

        if (clienteExistente.isPresent()){
            Cliente ClienteActualizado = clienteExistente.get();

            // Actualizar las propiedades del servicio
            ClienteActualizado.setId_cliente(cli.getId_cliente());
            ClienteActualizado.setNombre(cli.getNombre());
            ClienteActualizado.setApellido(cli.getApellido());
            ClienteActualizado.setSexo(cli.getSexo());
            ClienteActualizado.setTelefono(cli.getTelefono());
            ClienteActualizado.setEdad(cli.getEdad());
            ClienteActualizado.setImagen(cli.getImagen());

            // Actualizar las llaves foráneas si es necesario
            ClienteActualizado.setUsuario(cli.getUsuario());


            repositorio.save(ClienteActualizado);
            return "El servicio se actualizó exitosamente";
        } else {
            return "El servicio no se puede actualizar";
        }
    }


    public String EliminarCliente(int id){
        if (repositorio.findById(id).isPresent()){
            repositorio.deleteById(id);
            return ("El cliente se elimino con exito");
        }
        else {
            return ("El cliente no esta en la base de datos");
        }
    }
}
