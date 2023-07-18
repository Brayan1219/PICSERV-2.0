package com.example.Picserv_Backend.Controlador;


import com.example.Picserv_Backend.Entidad.Postulados;
import com.example.Picserv_Backend.Entidad.Trabajador;
import com.example.Picserv_Backend.Servicio.ServicioPostulados;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorPostulados {

    private ServicioPostulados servicio;

    public ControladorPostulados(ServicioPostulados servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarPostulados")
    public ArrayList<Postulados> ListarPostulados(){
        return servicio.ListarPostulados();
    }

    @GetMapping("BuscarPostulados/{idTrabajador}")
    public ResponseEntity<List<Postulados>> obtenerPostuladosPorTrabajador(@PathVariable int idTrabajador) {
        Trabajador trabajador = new Trabajador(idTrabajador);
        List<Postulados> postulados = servicio.BuscarPostulados(trabajador);
        return ResponseEntity.ok(postulados);
    }

    @PostMapping("/AgregarPostulados/{idTrabajador}/{idServicio}")
    public String AgregarPostulados( @PathVariable int idTrabajador,@PathVariable int idServicio){
        return servicio.AgregarPostulados(idTrabajador,idServicio);
    }

    @DeleteMapping("EliminarPostulados/{idTrabajador}")
    public ResponseEntity<String> EliminarPostulados(@PathVariable int idTrabajador) {
        Trabajador trabajador = new Trabajador(idTrabajador);
        servicio.EliminarPostulados(trabajador);
        return ResponseEntity.ok("Postulacion eliminada");
    }


}
