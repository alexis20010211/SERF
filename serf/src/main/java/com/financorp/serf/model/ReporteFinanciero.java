package com.financorp.serf.model;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * Representa un reporte financiero dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y utiliza el patrón
 * Singleton mediante {@link ConfiguracionGlobal} para obtener
 * valores globales del sistema.
 * </p>
 *
 * <p>Puede ser construido mediante un Builder (ReporteFinancieroBuilder)
 * para definir título, periodo, departamento, datos, gráficos y conclusiones.</p>
 */
public class ReporteFinanciero implements Reporte {

    // ====== Datos del Singleton ======
    private String pais;
    private String moneda;
    private String formatoFecha;

    // ====== Datos definidos por el Builder ======
    private String titulo;
    private String periodo;
    private String departamento;
    private String datos;
    private String graficos;
    private String conclusiones;

    /**
     * Constructor por defecto: inicializa valores globales desde el Singleton.
     */
    public ReporteFinanciero() {
        ConfiguracionGlobal config = ConfiguracionGlobal.getInstancia();
        this.pais = config.getPaisSede();
        this.moneda = config.getMonedaCorporativa();
        this.formatoFecha = config.getFormatoFecha();
    }

    // ====== Implementación del método de la interfaz ======
    @Override
    public String generar() {
        return """
📊 REPORTE FINANCIERO
Título: %s
Periodo: %s
Departamento: %s

Datos: %s
Gráficos: %s
Conclusiones: %s

🌎 Configuración Global:
- País: %s
- Moneda: %s
- Formato Fecha: %s
""".formatted(
                titulo, periodo, departamento,
                datos, graficos, conclusiones,
                pais, moneda, formatoFecha
        );
    }

    // ====== Getters y Setters ======
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getDatos() { return datos; }
    public void setDatos(String datos) { this.datos = datos; }

    public String getGraficos() { return graficos; }
    public void setGraficos(String graficos) { this.graficos = graficos; }

    public String getConclusiones() { return conclusiones; }
    public void setConclusiones(String conclusiones) { this.conclusiones = conclusiones; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getMoneda() { return moneda; }
    public void setMoneda(String moneda) { this.moneda = moneda; }

    public String getFormatoFecha() { return formatoFecha; }
    public void setFormatoFecha(String formatoFecha) { this.formatoFecha = formatoFecha; }
}
