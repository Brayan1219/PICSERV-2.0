package com.example.Picserv_Backend.Controlador;

import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Servicio.ServicioCliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorCliente {

    private ServicioCliente servicio;

    public ControladorCliente(ServicioCliente servicio){
        this.servicio=servicio;
    }

    @GetMapping("/ListarCliente")
    public ArrayList<Cliente> ListarCliente(){
        return servicio.ListarCLiente();
    }

    @GetMapping("/BuscarCliente/{id}")
    public Cliente BuscarCliente(@PathVariable("id")int id){
        return servicio.BuscarCliente(id);
    }

    @PostMapping("/AgregarCliente/{id_usuario}")
    public String agregarCliente(@RequestBody Cliente cliente, @PathVariable int id_usuario) {
        String respuesta = servicio.AgregarCliente(cliente, id_usuario);
        return respuesta;
    }

    @PutMapping("/ActualizarCliente")
    public String ActualizarCliente(@RequestBody Cliente cli){
        return servicio.ActualizarCliente(cli);
    }

    @PutMapping("/ActualizarCli")
    public String ActualizarCli(@RequestBody Cliente cli){
        return servicio.Actualizarcli(cli);
    }

    @DeleteMapping("/EliminarCliente/{doc}")
    public String EliminarCliente(@PathVariable("id")int id){
        return servicio.EliminarCliente(id);
    }
}
