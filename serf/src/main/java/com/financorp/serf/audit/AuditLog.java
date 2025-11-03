package com.financorp.serf.audit;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Representa un registro de auditoría del sistema SERF.
 * Guarda información sobre qué usuario realizó una acción, cuándo y cuál fue.
 */
@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Ahora Long para JPA

    private String usuario;
    private String accion;
    private LocalDateTime fechaHora;

    // Constructor vacío requerido por JPA
    public AuditLog() {}

    public AuditLog(String usuario, String accion) {
        this.usuario = usuario;
        this.accion = accion;
        this.fechaHora = LocalDateTime.now();
    }

    // ===== Getters y Setters =====
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", accion='" + accion + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
