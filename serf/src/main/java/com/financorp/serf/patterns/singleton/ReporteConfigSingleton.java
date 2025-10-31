package com.financorp.serf.patterns.singleton;

public class ReporteConfigSingleton {

    // Instancia única
    private static ReporteConfigSingleton instancia;

    // Configuración global de reportes
    private String formato; // ejemplo: "PDF", "EXCEL", "HTML"
    private boolean incluirEncabezado;
    private boolean incluirPieDePagina;

    // Constructor privado para evitar instanciación externa
    private ReporteConfigSingleton() {
        // Valores por defecto
        this.formato = "PDF";
        this.incluirEncabezado = true;
        this.incluirPieDePagina = true;
    }

    // Método para obtener la instancia única
    public static ReporteConfigSingleton getInstance() {
        if (instancia == null) {
            instancia = new ReporteConfigSingleton();
        }
        return instancia;
    }

    // Getters y setters
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public boolean isIncluirEncabezado() {
        return incluirEncabezado;
    }

    public void setIncluirEncabezado(boolean incluirEncabezado) {
        this.incluirEncabezado = incluirEncabezado;
    }

    public boolean isIncluirPieDePagina() {
        return incluirPieDePagina;
    }

    public void setIncluirPieDePagina(boolean incluirPieDePagina) {
        this.incluirPieDePagina = incluirPieDePagina;
    }

    // Método de utilidad para mostrar configuración actual
    public void mostrarConfiguracion() {
        System.out.println("Formato: " + formato);
        System.out.println("Incluir Encabezado: " + incluirEncabezado);
        System.out.println("Incluir Pie de Página: " + incluirPieDePagina);
    }
}
