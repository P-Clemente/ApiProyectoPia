package com.proyectopia.pia.repository;
import com.proyectopia.pia.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tareas, Integer> {
    List<Tareas> findByIdUsuarioAsignado(Integer idUsuarioAsignado);
}
