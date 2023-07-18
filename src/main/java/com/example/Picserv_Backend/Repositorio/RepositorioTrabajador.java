package com.example.Picserv_Backend.Repositorio;

import com.example.Picserv_Backend.Entidad.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTrabajador extends JpaRepository<Trabajador,Integer> {
}
