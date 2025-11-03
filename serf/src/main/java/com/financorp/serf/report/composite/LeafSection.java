package com.financorp.serf.report.composite;

public class LeafSection extends ReportComponent {
    private final String contenido;

    public LeafSection(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public void generar() {
        System.out.println(" - Contenido: " + contenido);
    }
}
