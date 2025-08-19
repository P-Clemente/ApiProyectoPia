package com.proyectopia.pia.model;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table (name = "roles")
public class Rol {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL")
    private Integer idRol;

    @Column(name = "NOMBRE_ROL", nullable = false, length = 100)
    private String nombreRol;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Usuario> usuarios;

    public Integer getIdRol() {
        return idRol;
    }

    public String getNombre() {
        return nombreRol;
    }

    public List<Usuario> getUsuarios () {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
