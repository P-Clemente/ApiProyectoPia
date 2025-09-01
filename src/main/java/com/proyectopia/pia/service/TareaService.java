package com.proyectopia.pia.service;
import com.proyectopia.pia.model.*;
import com.proyectopia.pia.repository.TareaRepository;
import com.proyectopia.pia.repository.UsuarioRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Map<String, Object> asignarTareas(Tareas tarea) {
        Map<String, Object> response = new HashMap<>();

        Optional<Usuario> usuarioAsignaOpt = usuarioRepository.findById(tarea.getIdUsuarioAsigna());
        if (usuarioAsignaOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "El usuario que asigna la tarea no existe");
            return response;
        }

        Usuario usuarioAsigna = usuarioAsignaOpt.get();
        if (!usuarioAsigna.getRol().getIdRol().equals(1)) {
            response.put("status", "error");
            response.put("message", "El usuario no tiene permisos para asignar tareas");
            return response;
        }

        if (tarea.getIdUsuarioAsignado() == null) {
            response.put("status", "error");
            response.put("message", "El usuario asignado no puede ser nulo");
            return response;
        }

        try {
            tarea.setFechaAsignacion(Date.valueOf(LocalDate.now()));
            tarea.setEstadoTarea("Asignada");

            Tareas tareaGuardada = tareaRepository.save(tarea);

            response.put("status", "ok");
            response.put("tarea", tareaGuardada);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error al guardar la tarea: " + e.getMessage());
        }

        return response;
    }

    public Map<String, Object> obtenerTareasPorUsuario(Integer idUsuario) {
        Map<String, Object> response = new HashMap<>();

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        if (usuarioOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Usuario no existe");
            return response;
        }

        try {
            List<Tareas> tareas = tareaRepository.findByIdUsuarioAsignado(idUsuario);
            response.put("status", "ok");
            response.put("tareas", tareas);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error al obtener las tareas: " + e.getMessage());
        }

        return response;
    }

    public Map<String, Object> editarTarea(Integer idTarea, Tareas nuevaTarea) {
        Map<String, Object> response = new HashMap<>();

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(nuevaTarea.getIdUsuarioAsigna());
        if (usuarioOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Usuario editor no existe");
            return response;
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getRol().getIdRol().equals(1)) {
            response.put("status", "error");
            response.put("message", "El usuario no tiene permisos para editar tareas");
            return response;
        }

        Optional<Tareas> tareaOpt = tareaRepository.findById(idTarea);
        if (tareaOpt.isEmpty()) {
            response.put("status", "error");
            response.put("message", "Tarea no encontrada");
            return response;
        }

        try {
            Tareas tarea = tareaOpt.get();

            // Actualizar campos
            tarea.setNombreTarea(nuevaTarea.getNombreTarea());
            tarea.setDescripcion(nuevaTarea.getDescripcion());
            tarea.setEstadoTarea(nuevaTarea.getEstadoTarea());
            tarea.setPrioridad(nuevaTarea.getPrioridad());

            Tareas tareaActualizada = tareaRepository.save(tarea);

            response.put("status", "ok");
            response.put("tarea", tareaActualizada);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("message", "Error al actualizar la tarea: " + e.getMessage());
        }

        return response;
    }
}
