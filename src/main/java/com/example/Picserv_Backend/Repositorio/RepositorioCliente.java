package com.example.Picserv_Backend.Repositorio;

import com.example.Picserv_Backend.Entidad.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente,Integer> {
}
