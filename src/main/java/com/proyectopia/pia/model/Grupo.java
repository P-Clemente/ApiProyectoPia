package com.proyectopia.pia.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GRUPO")
    private Integer idGrupo;

    @Column(name = "NOMBRE_GRUPO", nullable = false, length = 1000)
    private String nombreGrupo;

    @Column(name = "DESCRIPCION", nullable = false, length = 3000)
    private String descripcion;

    @Column(name = "FECHA_CREACION", nullable = false)
    private Date fechaCreacion;

    /* Get */
    public Integer getIdGrupo() {
        return idGrupo;
    }  
    public String getNombreGrupo() {
        return nombreGrupo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /* Set */
    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }
    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
