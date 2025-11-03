package com.financorp.serf.model;

import java.util.List;

/**
 * Representa un reporte de ventas dentro del sistema SERF.
 * <p>
 * Implementa la interfaz {@link Reporte} y utiliza el método por defecto
 * {@link Reporte#obtenerConfiguracion()} que accede al patrón
 * <b>Singleton</b> implementado en {@code ConfiguracionGlobal}.
 * </p>
 *
 * <p>Este reporte consolida información de ventas por producto, filial y periodo,
 * permitiendo una visión general del rendimiento comercial de cada filial o sede.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * ReporteVentas reporte = new ReporteVentas(listaVentas);
 * System.out.println(reporte.generar());
 * }</pre>
 *
 * @author Alesi
 * @version 2.0
 * @see com.financorp.serf.model.Reporte
 * @see com.financorp.serf.patterns.singleton.ConfiguracionGlobal
 */
public class ReporteVentas implements Reporte {

    private List<Venta> ventas;

    /**
     * Constructor que recibe la lista de ventas para generar el reporte.
     *
     * @param ventas lista de ventas registradas en el sistema
     */
    public ReporteVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    /**
     * Genera el contenido del reporte de ventas.
     *
     * @return texto descriptivo con los datos del reporte y la configuración global
     */
    @Override
    public String generar() {
        StringBuilder sb = new StringBuilder();
        sb.append("💰 REPORTE DE VENTAS\n\n");

        if (ventas == null || ventas.isEmpty()) {
            sb.append("No hay ventas registradas.\n");
        } else {
            sb.append("Detalle de ventas por filial y producto:\n");
            for (Venta v : ventas) {
                sb.append(String.format(
                        "- Filial: %s | Producto: %s | Cliente: %s | Cantidad: %d | Precio Unitario: %.2f %n",
                        v.getFilial().getNombre(),
                        v.getProducto().getNombre(),
                        v.getCliente().getNombre(),
                        v.getCantidad(),
                        v.getPrecioUnitario()
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
    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
