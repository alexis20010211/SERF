package com.financorp.serf.report.prototype;

/**
 * Clase base para plantillas de reportes usando el patrón Prototype.
 * Permite clonar instancias de reportes para reutilización.
 */
public class ReportTemplate implements Cloneable {

    private String titulo;
    private String contenido;
    private String autor;

    public ReportTemplate() {}

    public ReportTemplate(String titulo, String contenido, String autor) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.autor = autor;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    @Override
    public ReportTemplate clone() {
        try {
            return (ReportTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonación no soportada", e);
        }
    }

    @Override
    public String toString() {
        return "ReportTemplate{" +
                "titulo='" + titulo + '\'' +
                ", contenido='" + contenido + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
