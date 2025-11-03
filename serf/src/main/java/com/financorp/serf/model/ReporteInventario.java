package com.financorp.serf.model;

import java.util.List;

import com.financorp.serf.patterns.singleton.ConfiguracionGlobal;

/**
 * Representa un reporte de inventario dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y utiliza el patrón
 * Singleton mediante {@link ConfiguracionGlobal} para incluir
 * la configuración global del sistema.
 * </p>
 *
 * <p>Este reporte incluye información sobre existencias actuales,
 * rotación de productos y valoración de activos disponibles
 * en los distintos almacenes o filiales.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReporteInventario reporte = new ReporteInventario(listaInventarioFiliales);
 * System.out.println(reporte.generar());
 * }</pre>
 *
 * @author Alesi
 * @version 2.0
 * @see com.financorp.serf.model.Reporte
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public class ReporteInventario implements Reporte {

    private List<InventarioFilial> inventarios;

    /**
     * Constructor que recibe la lista de inventarios para generar el reporte.
     *
     * @param inventarios lista de inventarios de todas las filiales
     */
    public ReporteInventario(List<InventarioFilial> inventarios) {
        this.inventarios = inventarios;
    }

    /**
     * Genera el contenido del reporte de inventario.
     *
     * @return texto descriptivo con los datos del reporte y la configuración global
     */
    @Override
    public String generar() {
        StringBuilder sb = new StringBuilder();
        sb.append("📦 REPORTE DE INVENTARIO\n\n");

        if (inventarios == null || inventarios.isEmpty()) {
            sb.append("No hay inventarios disponibles.\n");
        } else {
            sb.append("Detalle de inventarios por filial:\n");
            for (InventarioFilial inv : inventarios) {
                sb.append(String.format(
                        "- Filial: %s | Producto: %s | Stock: %d %n",
                        inv.getFilial().getNombre(),
                        inv.getProducto().getNombre(),
                        inv.getStock()
                ));
            }
        }

        sb.append("\n🌎 Configuración Global:\n");
        sb.append(obtenerConfiguracion());

        return sb.toString();
    }

    // ==========================
    // Getters y Setters
    // ==========================
    public List<InventarioFilial> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<InventarioFilial> inventarios) {
        this.inventarios = inventarios;
    }
}
