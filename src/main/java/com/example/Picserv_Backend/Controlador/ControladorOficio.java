package com.example.Picserv_Backend.Controlador;

import com.example.Picserv_Backend.Entidad.Oficio;
import com.example.Picserv_Backend.Entidad.Usuario;
import com.example.Picserv_Backend.Servicio.ServicioOficio;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorOficio {

    private ServicioOficio servicio;

    public ControladorOficio(ServicioOficio servicio){
        this.servicio=servicio;
    }

    @GetMapping("/ListarOficios")
    public ArrayList<Oficio> ListarOficio(){
        return servicio.ListarOficio();
    }

    @GetMapping("/BuscarOficio/{id}")
    public Oficio BuscarOficio(@PathVariable("id")int id){
        return servicio.BuscarOficio(id);
    }

    @PostMapping("/AgregarOficio")
    public String AgregarOficio(@RequestBody Oficio ofi){
        return this.servicio.AgregarOficio(ofi);
    }

    @PutMapping("/ActualizarOficio")
    public String ActualizarOficio(@RequestBody Oficio ofi){
        return servicio.ActualizarOficio(ofi);
    }

    @DeleteMapping("/EliminarOficio/{doc}")
    public String EliminarOficio(@PathVariable("doc")int id){
        return servicio.EliminarOficio(id);
    }

}
