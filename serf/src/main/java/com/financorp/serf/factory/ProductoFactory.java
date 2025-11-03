package com.financorp.serf.factory;

import com.financorp.serf.model.Producto;

/**
 * Fábrica responsable de la creación de instancias de {@link Producto}.
 * 
 * Patrón aplicado: Factory Method
 */
public class ProductoFactory {

    /**
     * Crea una nueva instancia de {@link Producto} configurada con valores básicos.
     *
     * @param nombre nombre del producto
     * @param precioVenta precio sugerido de venta
     * @param categoria categoría o tipo del producto
     * @param moneda moneda local (PEN, USD, EUR)
     * @param stock stock inicial del lote
     * @return nueva instancia de {@link Producto}
     */
    public static Producto crearProducto(
            String nombre,
            double precioVenta,
            String categoria,
            String moneda,
            int stock
    ) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecioVentaSugerido(precioVenta);
        producto.setCategoria(categoria);
        producto.setMoneda(moneda);
        producto.setStock(stock);

        return producto;
    }
}
