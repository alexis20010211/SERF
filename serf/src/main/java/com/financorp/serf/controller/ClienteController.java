package com.financorp.serf.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financorp.serf.model.Cliente;
import com.financorp.serf.service.ClienteService;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los clientes.
 * Proporciona endpoints para listar, obtener, crear, actualizar y eliminar clientes.
 * 
 * <p>Ruta base: <b>/api/clientes</b></p>
 * 
 * <p>Permite peticiones desde cualquier origen (CORS habilitado).</p>
 * 
 * @author Alesi
 * @version 1.0
 */
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // permite peticiones desde el frontend
public class ClienteController {

    private final ClienteService clienteService;

    /**
     * Constructor del controlador que inyecta el servicio de clientes.
     *
     * @param clienteService servicio que maneja la lógica de negocio de clientes
     */
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /**
     * Obtiene la lista completa de clientes registrados.
     *
     * @return lista de objetos {@link Cliente}
     */
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.obtenerTodos();
    }

    /**
     * Obtiene un cliente específico según su identificador.
     *
     * @param id identificador único del cliente
     * @return objeto {@link Cliente} correspondiente al ID especificado
     */
    @GetMapping("/{id}")
    public Cliente obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerPorId(id);
    }

    /**
     * Crea un nuevo cliente en el sistema.
     *
     * @param cliente objeto {@link Cliente} con los datos del nuevo cliente
     * @return cliente creado con su ID asignado
     */
    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param id identificador del cliente a actualizar
     * @param cliente objeto {@link Cliente} con los datos actualizados
     * @return cliente actualizado
     */
    @PutMapping("/{id}")
    public Cliente actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.actualizar(id, cliente);
    }

    /**
     * Elimina un cliente del sistema según su identificador.
     *
     * @param id identificador del cliente a eliminar
     */
    @DeleteMapping("/{id}")
    public void eliminarCliente(@PathVariable Long id) {
        clienteService.eliminar(id);
    }
}
