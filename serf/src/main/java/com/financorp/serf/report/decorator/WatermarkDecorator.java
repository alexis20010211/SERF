package com.financorp.serf.report.decorator;

import com.financorp.serf.model.Reporte;

public class WatermarkDecorator extends ReportDecorator {

    public WatermarkDecorator(Reporte reporte) {
        super(reporte);
    }

    @Override
    public String generar() {
        return reporte.generar() + "\n💧 Marca de agua: CONFIDENCIAL FINANCORP";
    }
}
