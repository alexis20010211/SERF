package com.financorp.serf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.report.facade.ReporteFacadeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteFacadeService reporteFacadeService;

    @GetMapping("/generar")
    @Operation(
        summary = "Genera un reporte PDF",
        description = "Genera un PDF con los datos de la tabla según el tipo solicitado",
        responses = {
            @ApiResponse(responseCode = "200", description = "PDF generado correctamente"),
            @ApiResponse(responseCode = "400", description = "Tipo de reporte no válido")
        }
    )
    public ResponseEntity<byte[]> generarReporte(@RequestParam String tipo) {
        byte[] pdf = reporteFacadeService.generarReportePDF(tipo);

        if (pdf.length == 0) {
            return ResponseEntity.badRequest()
                    .body(("Tipo de reporte no válido: " + tipo).getBytes());
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);

        // Aquí forzamos la descarga
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("reporte-" + tipo + ".pdf")
                .build());

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
