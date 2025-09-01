package com.proyectopia.pia.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectopia.pia.model.*;
import com.proyectopia.pia.repository.GrupoRepository;
import com.proyectopia.pia.repository.GrupoUsuariosRepository;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoUsuariosRepository grupoUsuarioRepository;

    public Map<String, Object> crearGrupo(Grupo grupo) {
        Map<String, Object> response = new HashMap<>();
        try {
            grupo.setFechaCreacion(new Date(0));
            grupoRepository.save(grupo);
            response.put("status", "ok");
            response.put("grupo", grupo);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("mensaje", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> actualizarGrupo(Integer id, Grupo nuevoGrupo) {
        Map<String, Object> response = new HashMap<>();
        try {
            Grupo grupo = grupoRepository.findById(id).orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
            grupo.setNombreGrupo(nuevoGrupo.getNombreGrupo());
            grupo.setDescripcion(nuevoGrupo.getDescripcion());
            grupoRepository.save(grupo);
            response.put("status", "ok");
            response.put("grupo", grupo);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("mensaje", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> obtenerGrupos() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Grupo> grupos = grupoRepository.findAll();
            response.put("status", "ok");
            response.put("grupos", grupos);
        } catch (Exception e) {
            response.put("status", "error");
            response.put("mensaje", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> asignarUsuarioAGrupo(Integer idGrupo, Integer idUsuario) {
        Map<String, Object> response = new HashMap<>();
        try {
            GrupoUsuarioId id = new GrupoUsuarioId(idGrupo, idUsuario);
            GruposUsuario gu = new GruposUsuario(id);
            grupoUsuarioRepository.save(gu);
            response.put("status", "ok");
        } catch (Exception e) {
            response.put("status", "error");
            response.put("mensaje", e.getMessage());
        }
        return response;
    }
}
