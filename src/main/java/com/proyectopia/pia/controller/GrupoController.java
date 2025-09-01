package com.proyectopia.pia.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import com.proyectopia.pia.model.*;
import com.proyectopia.pia.service.GrupoService;

@RestController
@RequestMapping("/api/tareas/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping
    public Map<String, Object> crearGrupo(@RequestBody Grupo grupo) {
        return grupoService.crearGrupo(grupo);
    }

    @PutMapping("/{id}")
    public Map<String, Object> actualizarGrupo(@PathVariable Integer id, @RequestBody Grupo grupo) {
        return grupoService.actualizarGrupo(id, grupo);
    }

    @GetMapping
    public Map<String, Object> obtenerGrupos() {
        return grupoService.obtenerGrupos();
    }

    @PostMapping("/{idGrupo}/usuarios/{idUsuario}")
    public Map<String, Object> asignarUsuario(@PathVariable Integer idGrupo, @PathVariable Integer idUsuario) {
        return grupoService.asignarUsuarioAGrupo(idGrupo, idUsuario);
    }
}