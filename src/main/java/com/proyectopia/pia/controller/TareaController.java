package com.proyectopia.pia.controller;
import com.proyectopia.pia.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectopia.pia.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    @Autowired
    private TareaService tareaService;

    @PostMapping("/asignar")
    public ResponseEntity<Map<String, Object>> asignarTarea(@RequestBody Tareas tareas) {
        
        Map<String, Object> response = tareaService.asignarTareas(tareas);

        String status = (String) response.get("status");
        if ("error".equals(status)) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }

    // GET - obtener tareas por usuario
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Map<String, Object>> obtenerTareasPorUsuario(
            @PathVariable Integer idUsuario) {
        Map<String, Object> response = tareaService.obtenerTareasPorUsuario(idUsuario);

        String status = (String) response.get("status");
        if ("error".equals(status)) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    // PUT - editar tarea (solo admin rol=1)
    @PutMapping("/editar/{idTarea}")
    public ResponseEntity<Map<String, Object>> editarTarea(
            @PathVariable Integer idTarea,
            @RequestBody Tareas nuevaTarea) {

        Map<String, Object> response = tareaService.editarTarea(idTarea, nuevaTarea);

        if ("error".equals(response.get("status"))) {
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
    
}
