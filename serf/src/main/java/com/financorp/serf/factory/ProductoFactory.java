package com.financorp.serf.factory;

import com.financorp.serf.model.Producto;

/**
 * Fábrica responsable de la creación de instancias de {@link Producto}.
 * <p>
 * Este patrón permite centralizar la lógica de construcción de objetos,
 * facilitando la extensibilidad y el mantenimiento del código.
 * </p>
 *
 * <p><b>Patrón aplicado:</b> Factory Method</p>
 * 
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Producto laptop = ProductoFactory.crearProducto("Laptop Lenovo", 3500.0, "Tecnología");
 * }</pre>
 * 
 * @author Alesi
 * @version 1.0
 */
public class ProductoFactory {

    /**
     * Crea una nueva instancia de {@link Producto} configurada con los valores proporcionados.
     *
     * @param nombre    nombre del producto
     * @param precio    precio del producto
     * @param categoria categoría o tipo del producto
     * @return una nueva instancia de {@link Producto} con los datos asignados
     */
    public static Producto crearProducto(String nombre, double precio, String categoria) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCategoria(categoria);
        return producto;
    }
}
