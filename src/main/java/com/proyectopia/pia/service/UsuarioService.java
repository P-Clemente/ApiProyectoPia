package com.proyectopia.pia.service;

import com.proyectopia.pia.utils.HashUtil;
import com.proyectopia.pia.model.*;
import com.proyectopia.pia.repository.RolRepository;
import com.proyectopia.pia.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
    }

    public Usuario crearUsuario (String nombre1, String nombre2, String apellido1, String apellido2, String correo, String contrasena, Integer idRol, String estado) {
        Rol rol = rolRepository.findById(idRol).orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        if (usuarioRepository.existsByCorreoUsuario(correo)) {
            throw new RuntimeException("El correo ya está en uso");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre1(nombre1);
        usuario.setNombre2(nombre2);
        usuario.setApellido1(apellido1);
        usuario.setApellido2(apellido2);
        usuario.setCorreoUsuario(correo);
        usuario.setContrasena(HashUtil.sha1(contrasena));
        usuario.setRol(rol);
        usuario.setEstadoUsuario(estado);

        return usuarioRepository.save(usuario);
    }

    public boolean existePorCorreo(String correo) {
        return usuarioRepository.existsByCorreoUsuario(correo);
    }
}
