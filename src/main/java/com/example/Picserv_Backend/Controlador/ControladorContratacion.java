package com.example.Picserv_Backend.Controlador;

import com.example.Picserv_Backend.Entidad.Contratacion;
import com.example.Picserv_Backend.Entidad.Postulados;
import com.example.Picserv_Backend.Entidad.Trabajador;
import com.example.Picserv_Backend.Servicio.ServicioContratacio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorContratacion {

    private ServicioContratacio servicio;

    public ControladorContratacion(ServicioContratacio servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarContratacion")
    public ArrayList<Contratacion> ListarContratacion(){
        return servicio.ListarContratacion();
    }

    @GetMapping("BuscarContratacion/{idTrabajador}")
    public ResponseEntity<List<Contratacion>> obtenerContratacionPorTrabajador(@PathVariable int idTrabajador) {
        Trabajador trabajador = new Trabajador(idTrabajador);
        List<Contratacion> contratacion = servicio.BuscarContratacion(trabajador);
        return ResponseEntity.ok(contratacion);
    }

    @PostMapping("/AgregarContratacion/{idTrabajador}/{idServicio}")
    public String AgregarContratacion( @PathVariable int idTrabajador,@PathVariable int idServicio){
        return servicio.AgregarContratacion(idTrabajador,idServicio);
    }


}
