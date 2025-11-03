package com.financorp.serf.report.decorator;

import com.financorp.serf.model.Reporte;

public abstract class ReportDecorator implements Reporte {
    protected Reporte reporte;

    public ReportDecorator(Reporte reporte) {
        this.reporte = reporte;
    }

    @Override
    public String generar() {
        return reporte.generar();
    }
}
