package com.proyectopia.pia.model;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GrupoUsuarioId implements Serializable {

    @Column(name = "ID_GRUPO")
    private Integer idGrupo;

    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    public GrupoUsuarioId() {}

    public GrupoUsuarioId(Integer idGrupo, Integer idUsuario) {
        this.idGrupo = idGrupo;
        this.idUsuario = idUsuario;
    }

    public Integer getIdGrupo() { return idGrupo; }
    public void setIdGrupo(Integer idGrupo) { this.idGrupo = idGrupo; }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrupoUsuarioId)) return false;
        GrupoUsuarioId that = (GrupoUsuarioId) o;
        return idGrupo.equals(that.idGrupo) && idUsuario.equals(that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGrupo, idUsuario);
    }
}
