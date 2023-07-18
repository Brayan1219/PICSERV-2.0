package com.example.Picserv_Backend.Controlador;

import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Entidad.Oficio;
import com.example.Picserv_Backend.Entidad.Servicio;

import com.example.Picserv_Backend.Servicio.ServicioServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorServicio {

    private ServicioServicio fun;

    public ControladorServicio(ServicioServicio fun) {
        this.fun = fun;
    }

    @GetMapping("/ListarServicios")
    public ArrayList<Servicio> ListarServicios(){
        return fun.ListarServicio();
    }

    @GetMapping("/BuscarServicioServicio/{id_servicio}")
    public Servicio BuscarServicio(@PathVariable("id_servicio")int id_servicio){
        return fun.buscarServicioPorId(id_servicio);
    }

    @GetMapping("/BucarServicio/{clienteId}")
    public ResponseEntity<List<Servicio>> obtenerServiciosPorCliente(@PathVariable int clienteId) {
        Cliente cliente = new Cliente(clienteId); // Supongamos que tienes una entidad Cliente con un constructor que recibe el ID
        List<Servicio> servicios = fun.BuscarServicio(cliente);
        return ResponseEntity.ok(servicios);
    }

    @GetMapping("/BucarServicioOficio/{OficioId}")
    public ResponseEntity<List<Servicio>> obtenerServiciosPorOficio(@PathVariable int OficioId) {
        Oficio oficio = new Oficio(OficioId);
        List<Servicio> servicios = fun.BuscarPorOficio(oficio);
        return ResponseEntity.ok(servicios);
    }

    @PostMapping("/AgregarServicio/{idCliente}/{idOficio}")
    public String AgregarServicio(@RequestBody Servicio servicio, @PathVariable int idCliente,@PathVariable int idOficio){
        return fun.AgregarServicio(servicio,idCliente,idOficio);

    }

    @PutMapping("/ActualizarServicio")
    public String ActualizarServicio(@RequestBody Servicio ser){
        return fun.ActualizarServicio(ser);
    }

    @DeleteMapping("/EliminarServicio/{id}")
    public String EliminarServicio(@PathVariable("id")int id){
        return fun.EliminarServicio(id);
    }
}
