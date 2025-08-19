package com.proyectopia.pia.controller;
import org.springframework.web.bind.annotation.*;

import com.proyectopia.pia.model.Usuario;
import com.proyectopia.pia.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Map<String, Object>> crearUsuario(@RequestBody UsuarioRequest request) {
        Map<String, Object> response = new HashMap<>();

        if (usuarioService.existePorCorreo(request.getCorreoUsuario())) {
            response.put("status", false);
            response.put("message", "El correo ya se encuentra registrado");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        try {
            Usuario usuarioCreado = usuarioService.crearUsuario(
                request.getNombre1(),
                request.getNombre2(),
                request.getApellido1(),
                request.getApellido2(),
                request.getCorreoUsuario(),
                request.getContrasena(),
                request.getRol(),
                request.getEstadoUsuario()
            );

            response.put("status", true);
            response.put("message", "Usuario creado correctamente");
            response.put("usuarioId", usuarioCreado.getIdUsuario());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (RuntimeException e) {
            response.put("status", false);
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        } catch (Exception e) {
            response.put("status", false);
            response.put("message", "Error al crear el usuario: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        
    }

    public static class UsuarioRequest {
        private String nombre1;
        private String nombre2;
        private String apellido1;
        private String apellido2;
        private String correoUsuario;
        private String contrasena;
        private Integer rol;
        private String estadoUsuario;

        // Getters y Setters
        public String getNombre1() { 
            return nombre1; 
        }
        public void setNombre1(String nombre1) { 
            this.nombre1 = nombre1; 
        }

        public String getNombre2() { 
            return nombre2; 
        }
        public void setNombre2(String nombre2) { 
            this.nombre2 = nombre2; 
        }

        public String getApellido1() { 
            return apellido1; 
        }
        public void setApellido1(String apellido1) { 
            this.apellido1 = apellido1; 
        }

        public String getApellido2() { 
            return apellido2; 
        }
        public void setApellido2(String apellido2) { 
            this.apellido2 = apellido2; 
        }

        public String getCorreoUsuario() { 
            return correoUsuario; 
        }
        public void setCorreoUsuario(String correoUsuario) { 
            this.correoUsuario = correoUsuario; 
        }

        public String getContrasena() { 
            return contrasena; 
        }
        public void setContrasena(String contrasena) { 
            this.contrasena = contrasena;
        }

        public Integer getRol() { 
            return rol; 
        }
        public void setRol(Integer rol) { 
            this.rol = rol; 
        }

        public String getEstadoUsuario() { 
            return estadoUsuario; 
        }
        public void setEstadoUsuario(String estadoUsuario) { 
            this.estadoUsuario = estadoUsuario; 
        }
    }
}
