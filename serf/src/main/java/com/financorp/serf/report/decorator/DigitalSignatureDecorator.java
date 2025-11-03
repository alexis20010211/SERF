package com.financorp.serf.report.decorator;

import com.financorp.serf.model.Reporte;

public class DigitalSignatureDecorator extends ReportDecorator {

    public DigitalSignatureDecorator(Reporte reporte) {
        super(reporte);
    }

    @Override
    public String generar() {
        return reporte.generar() + "\n🖋️ Firma Digital: Director Financiero - FINANCORP";
    }
}
