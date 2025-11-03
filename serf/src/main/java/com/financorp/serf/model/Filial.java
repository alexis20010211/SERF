package com.financorp.serf.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Representa una filial de FinanCorp dentro del sistema SERF.
 * <p>
 * Esta clase mapea la tabla <b>filiales</b> en la base de datos.
 * Contiene información de la filial y su inventario asociado.
 * </p>
 */
@Entity
@Table(name = "filiales")
public class Filial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String pais;

    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<InventarioFilial> inventario = new ArrayList<>();

    // ==========================
    // Constructores
    // ==========================
    public Filial() {}

    public Filial(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }

    // ==========================
    // Getters y Setters
    // ==========================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public List<InventarioFilial> getInventario() { return inventario; }

    // ==========================
    // Métodos helper para inventario
    // ==========================
    public void agregarInventario(InventarioFilial inv) {
        inventario.add(inv);
        inv.setFilial(this);
    }

    public void eliminarInventario(InventarioFilial inv) {
        inventario.remove(inv);
        inv.setFilial(null);
    }

    // ==========================
    // ToString para debugging
    // ==========================
    @Override
    public String toString() {
        return "Filial{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", inventario=" + inventario.size() +
                '}';
    }
}
