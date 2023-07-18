package com.example.Picserv_Backend.Repositorio;
import com.example.Picserv_Backend.Entidad.Postulados;
import com.example.Picserv_Backend.Entidad.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPostulados extends JpaRepository<Postulados,Integer> {

    List<Postulados> findByTrabajador(Trabajador trabajador);
}
