package com.financorp.serf.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Filial;
import com.financorp.serf.model.InventarioFilial;
import com.financorp.serf.model.Producto;
import com.financorp.serf.model.Venta;
import com.financorp.serf.repository.ClienteRepository;
import com.financorp.serf.repository.FilialRepository;
import com.financorp.serf.repository.InventarioFilialRepository;
import com.financorp.serf.repository.ProductoRepository;
import com.financorp.serf.repository.VentaRepository;
import com.financorp.serf.util.CurrencyConverter;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FilialRepository filialRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private InventarioFilialRepository inventarioFilialRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    public Venta registrarVenta(Venta venta) throws Exception {

        Producto prod = productoRepository.findById(venta.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Filial filial = filialRepository.findById(venta.getFilial().getId())
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));

        // ✅ Solo validamos existencia del cliente, ya no se crea variable
        clienteRepository.findById(venta.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        InventarioFilial inventario = inventarioFilialRepository.findByFilialAndProducto(filial, prod)
                .orElseThrow(() -> new RuntimeException("Producto no disponible en esta filial"));

        if (inventario.getStock() < venta.getCantidad()) {
            throw new Exception("Stock insuficiente en esta filial");
        }

        // ✅ Actualiza el stock
        inventario.setStock(inventario.getStock() - venta.getCantidad());
        inventarioFilialRepository.save(inventario);

        // ✅ Conversión de moneda
        Double totalLocal = venta.getCantidad() * venta.getPrecioUnitario();
        Double totalEUR = currencyConverter.convertToCorporateCurrency(totalLocal);
        venta.setTotalVentaEUR(totalEUR);

        // ✅ Fecha de venta
        venta.setFechaVenta(LocalDateTime.now());

        return ventaRepository.save(venta);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    public List<Venta> listarPorFilial(Long idFilial) {
        Filial filial = filialRepository.findById(idFilial)
                .orElseThrow(() -> new RuntimeException("Filial no encontrada"));

        return ventaRepository.findByFilial(filial);
    }
}
