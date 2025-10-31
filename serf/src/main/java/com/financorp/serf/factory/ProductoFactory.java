package com.financorp.serf.factory;

import com.financorp.serf.model.Producto;

public class ProductoFactory {

    public static Producto crearProducto(String nombre, double precio, String categoria) {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCategoria(categoria); // ahora funciona
        return producto;
    }
}
