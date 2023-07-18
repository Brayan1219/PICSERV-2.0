package com.example.Picserv_Backend.Repositorio;
import com.example.Picserv_Backend.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {
    Usuario findByIdUsuarioAndContraseña(int idUsuario, String contraseña);
}