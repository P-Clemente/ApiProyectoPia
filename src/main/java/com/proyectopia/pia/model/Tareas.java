package com.proyectopia.pia.model;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tareas")
public class Tareas {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA")
    private Integer idTarea;

    @Column(name = "NOMBRE_TAREA", nullable = false, length = 255)
    private String nombreTarea;

    @Column(name = "DESCRIPCION", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "USUARIO_ASIGNADO", nullable = false, length = 11)
    private Integer idUsuarioAsignado;

    @Column(name = "USUARIO_ASIGNA", nullable = false, length = 11)
    private Integer idUsuarioAsigna;

    private String estadoTarea;

    @Column(name = "PRIORIDAD", nullable = false, length = 255)
    private String prioridad;

    @Column(name = "FECHA_ASIGNACION", nullable = false)
    private Date fechaAsignacion;

    @Column(name = "FECHA_FINALIZACION", nullable = true)
    private Date fechaFinalizacion;

    /* Get */
    public Integer getIdTarea() {
        return idTarea;
    }
    public String getNombreTarea() {
        return nombreTarea;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Integer getIdUsuarioAsignado() {
        return idUsuarioAsignado;
    }
    public Integer getIdUsuarioAsigna() {
        return idUsuarioAsigna;
    }
    public String getEstadoTarea() {
        return estadoTarea;
    }   
    public String getPrioridad() {
        return prioridad;
    }
    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    /* Set */
    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }   
    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setIdUsuarioAsignado(Integer idUsuarioAsignado) {
        this.idUsuarioAsignado = idUsuarioAsignado;
    }
    public void setIdUsuarioAsigna(Integer idUsuarioAsigna) {
        this.idUsuarioAsigna = idUsuarioAsigna;
    }
    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }
}
