package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financorp.serf.model.Cliente;
import com.financorp.serf.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Constructor para inyección de dependencias
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // 🟢 Obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    // 🟣 Buscar cliente por ID
    public Cliente obtenerPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    // 🟡 Guardar nuevo cliente
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // 🔵 Actualizar cliente existente
    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNombre(clienteActualizado.getNombre());
                    cliente.setCorreo(clienteActualizado.getCorreo());
                    cliente.setTelefono(clienteActualizado.getTelefono());
                    return clienteRepository.save(cliente);
                })
                .orElse(null);
    }

    // 🔴 Eliminar cliente
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
