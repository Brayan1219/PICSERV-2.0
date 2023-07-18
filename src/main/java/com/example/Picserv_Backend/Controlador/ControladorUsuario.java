package com.example.Picserv_Backend.Controlador;

import com.example.Picserv_Backend.Entidad.Usuario;
import com.example.Picserv_Backend.Servicio.ServicioUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = {"GET", "POST", "PUT", "DELETE"})
public class ControladorUsuario {

    private ServicioUsuario servicio;

    public ControladorUsuario(ServicioUsuario servicio){
        this.servicio=servicio;
    }

    @GetMapping("/ListarUsuarios")
    public ArrayList<Usuario> ListarUsuario(){
        return servicio.ListarUsuario();
    }

    @GetMapping("/BuscarUsuario/{id}")
    public Usuario BuscarUsuario(@PathVariable("id")int id){
        return servicio.BuscarUsuario(id);
    }

    @PostMapping("/AgregarUsuario")
    public String AgregarUsuario(@RequestBody Usuario usu){
        return this.servicio.AgregarUsuario(usu);
    }

    @PutMapping("/ActualizarUsuario")
    public String ActualizarUsuario(@RequestBody Usuario usu){
        return servicio.ActualizarUsuario(usu);
    }

    @DeleteMapping("/EliminarUsuario/{id}")
    public String EliminarUsuario(@PathVariable("id")int id){
        return servicio.EliminarUsuario(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam int idUsuario, @RequestParam String contraseña) {
        String role = servicio.login(idUsuario, contraseña);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
