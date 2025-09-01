package com.proyectopia.pia.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "grupos_usuarios")
public class GruposUsuario implements Serializable {
     @EmbeddedId
    private GrupoUsuarioId id;

    // Constructor
    public GruposUsuario() {}

    public GruposUsuario(GrupoUsuarioId id) {
        this.id = id;
    }

    public GrupoUsuarioId getId() {
        return id;
    }

    public void setId(GrupoUsuarioId id) {
        this.id = id;
    }
}

