package com.proyectopia.pia.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @Column(name = "USUARIO_NOMBRE1", nullable = false, length = 1000)
    private String nombre1;

    @Column(name = "USUARIO_NOMBRE2", nullable = false, length = 1000)
    private String nombre2;

    @Column(name = "USUARIO_APELLIDO1", nullable = false, length = 1000)
    private String apellido1;

    @Column(name = "USUARIO_APELLIDO2", nullable = false, length = 1000)
    private String apellido2;

    @Column(name = "CORREO_USUARIO", nullable = false, length = 1000)
    private String correoUsuario;

    @Column(name = "CONTRASENA", nullable = false, length = 1000)
    private String contrasena;
    
    @ManyToOne
    @JoinColumn(name = "ID_ROL", nullable = false,
    foreignKey = @ForeignKey(name = "FK_USUARIO_ROL"))
    @JsonBackReference
    private Rol rol;

    @Column(name = "ESTADO_USUARIO", nullable = false, length = 20)
    private String estadoUsuario;

    /* Get */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombre1() {
        return nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCorreoUsuario() { 
        return correoUsuario; 
    }

    public String getContrasena() { 
        return contrasena; 
    }

    public Rol getRol() { 
        return rol; 
    }
    
    public String getEstadoUsuario() { 
        return estadoUsuario; 
    }

    /* Set */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre1(String nombre1) { 
        this.nombre1 = nombre1; 
    }

    public void setNombre2(String nombre2) { 
        this.nombre2 = nombre2; 
    }

    public void setApellido1(String apellido1) { 
        this.apellido1 = apellido1; 
    }

    public void setApellido2(String apellido2) { 
        this.apellido2 = apellido2; 
    }

    public void setCorreoUsuario(String correoUsuario) { 
        this.correoUsuario = correoUsuario; 
    }

    public void setContrasena(String contrasena) { 
        this.contrasena = contrasena; 
    }

    public void setRol(Rol rol) { 
        this.rol = rol; 
    }

    public void setEstadoUsuario(String estadoUsuario) { 
        this.estadoUsuario = estadoUsuario; 
    }
}
