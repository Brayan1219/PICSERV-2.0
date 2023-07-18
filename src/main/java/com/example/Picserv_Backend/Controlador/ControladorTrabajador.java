package com.example.Picserv_Backend.Controlador;


import com.example.Picserv_Backend.Entidad.Trabajador;
import com.example.Picserv_Backend.Servicio.ServicioTrabajador;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorTrabajador {

    private ServicioTrabajador servicio;

    public ControladorTrabajador(ServicioTrabajador servicio){
        this.servicio=servicio;
    }

    @GetMapping("/ListarTrabajador")
    public ArrayList<Trabajador> ListarTrabajador(){
        return servicio.ListarTrabajador();
    }

    @GetMapping("/BuscarTrabajador/{id}")
    public Trabajador BuscarTrabajador(@PathVariable("id")int id){
        return servicio.buscarTrabajador(id);
    }


    @PostMapping("/AgregarTrabajador/{id_usuario}/{idOficio}")
    public String agregarCliente(@RequestBody Trabajador trabajador, @PathVariable int id_usuario,@PathVariable int idOficio) {
        String respuesta = servicio.AgregarTrabajador(trabajador, id_usuario,idOficio);
        return respuesta;
    }

    @PutMapping("/ActualizarTrabajador")
    public String ActualizarTrabajador(@RequestBody Trabajador tra){
        return servicio.ActualizarTrabajador(tra);
    }

    @DeleteMapping("/EliminarTrabajador/{doc}")
    public String EliminarTrabajador(@PathVariable("id")int id){
        return servicio.EliminarTrabajador(id);
    }

}


