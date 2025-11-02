package com.financorp.serf.patterns.singleton;

/**
 * <h2>Patrón Singleton: Configuración Global de Reportes</h2>
 *
 * <p>
 * La clase {@code ReporteConfigSingleton} implementa el patrón <b>Singleton</b> para 
 * centralizar los parámetros de configuración utilizados en la generación de reportes 
 * del sistema SERF.
 * </p>
 *
 * <h3>Objetivo:</h3>
 * <p>
 * Garantizar que todas las áreas del sistema utilicen la misma configuración de formato,
 * encabezado y pie de página al generar reportes financieros, técnicos, de ventas o inventario.
 * </p>
 *
 * <h3>Ventajas:</h3>
 * <ul>
 *   <li>Evita inconsistencias en los formatos de reportes.</li>
 *   <li>Permite modificar configuraciones globales en un solo punto.</li>
 *   <li>Facilita el mantenimiento y la trazabilidad de parámetros de exportación.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * ReporteConfigSingleton config = ReporteConfigSingleton.getInstance();
 * config.setFormato("EXCEL");
 * config.setIncluirPieDePagina(false);
 * config.mostrarConfiguracion();
 * }</pre>
 *
 * <p>
 * Se complementa con {@link ConfiguracionGlobal} y {@link LoggerGlobal} como parte
 * del conjunto de Singletons centrales del sistema SERF.
 * </p>
 *
 * @author Alesi
 * @version 1.0
 */
public class ReporteConfigSingleton {

    /** Instancia única de configuración de reportes. */
    private static ReporteConfigSingleton instancia;

    /** Formato del reporte (ejemplo: PDF, EXCEL, HTML). */
    private String formato;

    /** Indica si se debe incluir un encabezado en el reporte. */
    private boolean incluirEncabezado;

    /** Indica si se debe incluir un pie de página en el reporte. */
    private boolean incluirPieDePagina;

    /**
     * Constructor privado para evitar la creación de múltiples instancias.
     * Define valores por defecto de configuración.
     */
    private ReporteConfigSingleton() {
        this.formato = "PDF";
        this.incluirEncabezado = true;
        this.incluirPieDePagina = true;
    }

    /**
     * Devuelve la instancia única de configuración de reportes.
     * Si no existe, la crea (instanciación diferida).
     *
     * @return instancia única de {@link ReporteConfigSingleton}
     */
    public static ReporteConfigSingleton getInstance() {
        if (instancia == null) {
            instancia = new ReporteConfigSingleton();
        }
        return instancia;
    }

    /** @return formato actual del reporte (PDF, EXCEL, HTML, etc.) */
    public String getFormato() {
        return formato;
    }

    /** @param formato nuevo formato de salida para los reportes */
    public void setFormato(String formato) {
        this.formato = formato;
    }

    /** @return {@code true} si el reporte incluye encabezado */
    public boolean isIncluirEncabezado() {
        return incluirEncabezado;
    }

    /** @param incluirEncabezado define si se incluirá encabezado en el reporte */
    public void setIncluirEncabezado(boolean incluirEncabezado) {
        this.incluirEncabezado = incluirEncabezado;
    }

    /** @return {@code true} si el reporte incluye pie de página */
    public boolean isIncluirPieDePagina() {
        return incluirPieDePagina;
    }

    /** @param incluirPieDePagina define si se incluirá pie de página en el reporte */
    public void setIncluirPieDePagina(boolean incluirPieDePagina) {
        this.incluirPieDePagina = incluirPieDePagina;
    }

    /**
     * Muestra la configuración actual del sistema de reportes por consola.
     * Útil para depuración o monitoreo del sistema.
     */
    public void mostrarConfiguracion() {
        System.out.println("=== Configuración Actual de Reportes ===");
        System.out.println("Formato: " + formato);
        System.out.println("Incluir Encabezado: " + incluirEncabezado);
        System.out.println("Incluir Pie de Página: " + incluirPieDePagina);
        System.out.println("========================================");
    }
}
