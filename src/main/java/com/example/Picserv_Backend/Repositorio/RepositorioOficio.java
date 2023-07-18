package com.example.Picserv_Backend.Repositorio;

import com.example.Picserv_Backend.Entidad.Oficio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOficio extends JpaRepository<Oficio,Integer> {
}
