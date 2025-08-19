package com.proyectopia.pia.repository;
import com.proyectopia.pia.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByCorreoUsuario(String correoUsuario);
    boolean existsByCorreoUsuario(String correo);
}
