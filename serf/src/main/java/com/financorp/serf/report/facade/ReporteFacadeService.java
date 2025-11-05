package com.financorp.serf.report.facade;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.financorp.serf.model.Cliente;
import com.financorp.serf.model.Filial;
import com.financorp.serf.model.Producto;
import com.financorp.serf.model.Solicitud;
import com.financorp.serf.model.Tecnico;
import com.financorp.serf.repository.ClienteRepository;
import com.financorp.serf.repository.FilialRepository;
import com.financorp.serf.repository.ProductoRepository;
import com.financorp.serf.repository.SolicitudRepository;
import com.financorp.serf.repository.TecnicoRepository;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

@Service
public class ReporteFacadeService {

    private final ProductoRepository productoRepo;
    private final ClienteRepository clienteRepo;
    private final FilialRepository filialRepo;
    private final TecnicoRepository tecnicoRepo;
    private final SolicitudRepository solicitudRepo;

    public ReporteFacadeService(
            ProductoRepository productoRepo,
            ClienteRepository clienteRepo,
            FilialRepository filialRepo,
            TecnicoRepository tecnicoRepo,
            SolicitudRepository solicitudRepo) {
        this.productoRepo = productoRepo;
        this.clienteRepo = clienteRepo;
        this.filialRepo = filialRepo;
        this.tecnicoRepo = tecnicoRepo;
        this.solicitudRepo = solicitudRepo;
    }

    public byte[] generarReportePDF(String tipo) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Encabezado simple
            document.add(new Paragraph("📊 REPORTE: " + tipo.toUpperCase()));

            switch (tipo.toLowerCase()) {
                case "producto":
                    Table tableP = new Table(5);
                    tableP.addHeaderCell("ID");
                    tableP.addHeaderCell("Nombre");
                    tableP.addHeaderCell("Código");
                    tableP.addHeaderCell("Precio");
                    tableP.addHeaderCell("Stock");
                    for (Producto p : productoRepo.findAll()) {
                        tableP.addCell(String.valueOf(p.getId()));
                        tableP.addCell(p.getNombre());
                        tableP.addCell(p.getCodigoProducto() != null ? p.getCodigoProducto() : "N/A");
                        tableP.addCell(String.valueOf(p.getPrecioVentaSugerido()));
                        tableP.addCell(String.valueOf(p.getStock()));
                    }
                    document.add(tableP);
                    break;

                case "cliente":
                    Table tableC = new Table(4);
                    tableC.addHeaderCell("ID");
                    tableC.addHeaderCell("Nombre");
                    tableC.addHeaderCell("Correo");
                    tableC.addHeaderCell("Teléfono");
                    for (Cliente c : clienteRepo.findAll()) {
                        tableC.addCell(String.valueOf(c.getId()));
                        tableC.addCell(c.getNombre());
                        tableC.addCell(c.getCorreo());
                        tableC.addCell(c.getTelefono());
                    }
                    document.add(tableC);
                    break;

                case "filial":
                    Table tableF = new Table(3);
                    tableF.addHeaderCell("ID");
                    tableF.addHeaderCell("Nombre");
                    tableF.addHeaderCell("País");
                    for (Filial f : filialRepo.findAll()) {
                        tableF.addCell(String.valueOf(f.getId()));
                        tableF.addCell(f.getNombre());
                        tableF.addCell(f.getPais());
                    }
                    document.add(tableF);
                    break;

                case "tecnico":
                    Table tableT = new Table(3);
                    tableT.addHeaderCell("ID");
                    tableT.addHeaderCell("Nombre");
                    tableT.addHeaderCell("Especialidad");
                    for (Tecnico t : tecnicoRepo.findAll()) {
                        tableT.addCell(String.valueOf(t.getId()));
                        tableT.addCell(t.getNombre());
                        tableT.addCell(t.getEspecialidad());
                    }
                    document.add(tableT);
                    break;

                case "solicitud":
                    Table tableS = new Table(4);
                    tableS.addHeaderCell("ID");
                    tableS.addHeaderCell("Cliente");
                    tableS.addHeaderCell("Tipo");
                    tableS.addHeaderCell("Monto");
                    for (Solicitud s : solicitudRepo.findAll()) {
                        String clienteNombre = s.getCliente() != null ? s.getCliente() : "N/A";
                        tableS.addCell(String.valueOf(s.getId()));
                        tableS.addCell(clienteNombre);
                        tableS.addCell(s.getTipo());
                        tableS.addCell(String.valueOf(s.getMonto()));
                    }
                    document.add(tableS);
                    break;

                default:
                    document.add(new Paragraph("Tipo de reporte no reconocido: " + tipo));
            }

            document.close();
            return baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
