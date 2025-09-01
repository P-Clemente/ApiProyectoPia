package com.proyectopia.pia.repository;
import com.proyectopia.pia.model.GruposUsuario;
import com.proyectopia.pia.model.GrupoUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoUsuariosRepository extends JpaRepository<GruposUsuario, GrupoUsuarioId> {}
