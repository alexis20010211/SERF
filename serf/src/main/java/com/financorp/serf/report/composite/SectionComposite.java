package com.financorp.serf.report.composite;

import java.util.ArrayList;
import java.util.List;

public class SectionComposite extends ReportComponent {
    private final String nombre;
    private final List<ReportComponent> secciones = new ArrayList<>();

    public SectionComposite(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ReportComponent componente) {
        secciones.add(componente);
    }

    @Override
    public void generar() {
        System.out.println("Generando sección: " + nombre);
        for (ReportComponent comp : secciones) {
            comp.generar();
        }
    }
}
