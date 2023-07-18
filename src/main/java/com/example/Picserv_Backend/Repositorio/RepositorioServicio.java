package com.example.Picserv_Backend.Repositorio;

import com.example.Picserv_Backend.Entidad.Cliente;
import com.example.Picserv_Backend.Entidad.Oficio;
import com.example.Picserv_Backend.Entidad.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioServicio extends JpaRepository<Servicio,Integer> {
    List<Servicio> findByCliente(Cliente cliente);

    List<Servicio> findByOficio(Oficio oficio);

}
