package com.financorp.serf.report.facade;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.financorp.serf.model.Reporte;
import com.financorp.serf.model.ReporteFinanciero;
import com.financorp.serf.report.builder.ReportDirector;
import com.financorp.serf.report.builder.ReporteFinancieroBuilder;

/**
 * Fachada para la generación y persistencia de reportes financieros.
 * <p>
 * Aplica el patrón <b>Facade</b> y utiliza internamente el patrón <b>Builder</b>.
 * Gestiona la construcción, registro y almacenamiento simulado de reportes dentro del sistema SERF.
 * </p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReportFacadeService fachada = new ReportFacadeService();
 * fachada.generarYGuardarReporteFinanciero();
 * }</pre>
 *
 * @author
 * @version 1.0
 */
@Service
public class ReportFacadeService {

    private final ReportService reportService = new ReportService();

    /**
     * Genera un reporte financiero usando el patrón Builder
     * y lo persiste mediante el servicio ReportService.
     *
     * @return ReporteFinanciero generado
     */
    public ReporteFinanciero generarYGuardarReporteFinanciero() {
        // 1️⃣ Construir el reporte usando Builder y Director
        ReporteFinancieroBuilder builder = new ReporteFinancieroBuilder();
        ReportDirector director = new ReportDirector(builder);
        Reporte reporteGenerico = director.construirReporte();

        // 2️⃣ Convertir a tipo concreto
        if (!(reporteGenerico instanceof ReporteFinanciero reporte)) {
            throw new IllegalStateException("El reporte construido no es financiero.");
        }

        // 3️⃣ Agregar información adicional
        reporte.setTitulo("Reporte Financiero General");

        // 4️⃣ Crear entidad simulada para persistencia
        ReportEntity entity = new ReportEntity();
        entity.setTitulo(reporte.getTitulo());
        entity.setDescripcion(reporte.generar());
        entity.setFechaGeneracion(LocalDateTime.now());

        // 5️⃣ Guardar reporte en “base de datos” (simulado)
        reportService.guardarReporte(entity);

        return reporte;
    }

    // ====================================================
    // 🔸 Clase interna simulada: servicio de persistencia
    // ====================================================
    private static class ReportService {
        public void guardarReporte(ReportEntity entity) {
            System.out.println("✅ Reporte guardado exitosamente:");
            System.out.println("Título: " + entity.getTitulo());
            System.out.println("Fecha: " + entity.getFechaGeneracion());
        }
    }

    // ====================================================
    // 🔸 Clase interna simulada: entidad del reporte
    // ====================================================
    private static class ReportEntity {
        private String titulo;
        private String descripcion;
        private LocalDateTime fechaGeneracion;

        public String getTitulo() { return titulo; }
        public void setTitulo(String titulo) { this.titulo = titulo; }

        @SuppressWarnings("unused") // Evita warning de método no usado localmente
        public String getDescripcion() { return descripcion; }
        public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

        public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }
        public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }
    }
}
