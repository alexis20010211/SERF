package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financorp.serf.model.Cliente;
import com.financorp.serf.repository.ClienteRepository;

/**
 * <h2>Servicio de Gestión de Clientes</h2>
 *
 * <p>
 * La clase {@code ClienteService} implementa la lógica de negocio
 * relacionada con la entidad {@link Cliente}. Se encarga de coordinar las
 * operaciones CRUD utilizando el repositorio {@link ClienteRepository}.
 * </p>
 *
 * <h3>Patrón de diseño aplicado:</h3>
 * <ul>
 *   <li><b>Service Layer (Capa de Servicio):</b> Aísla la lógica de negocio
 *       de la capa de persistencia, promoviendo la separación de responsabilidades.</li>
 *   <li><b>Dependency Injection:</b> El repositorio es inyectado a través del
 *       constructor, fomentando un código más limpio, testeable y desacoplado.</li>
 * </ul>
 *
 * <h3>Responsabilidades:</h3>
 * <ul>
 *   <li>Gestionar clientes: listar, buscar, registrar, actualizar y eliminar.</li>
 *   <li>Validar datos o aplicar reglas de negocio antes de persistir cambios.</li>
 *   <li>Delegar operaciones a {@link ClienteRepository} sin exponer detalles de la base de datos.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private ClienteService clienteService;
 *
 * // Crear nuevo cliente
 * Cliente nuevo = new Cliente("Juan Pérez", "juan@mail.com", "987654321");
 * clienteService.guardar(nuevo);
 *
 * // Obtener todos
 * List<Cliente> lista = clienteService.obtenerTodos();
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    /**
     * Constructor con inyección de dependencias.
     * 
     * @param clienteRepository el repositorio encargado de acceder a la base de datos.
     */
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Obtiene la lista completa de clientes registrados.
     *
     * @return lista de clientes existentes.
     */
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    /**
     * Busca un cliente por su identificador.
     *
     * @param id identificador único del cliente.
     * @return el cliente encontrado o {@code null} si no existe.
     */
    public Cliente obtenerPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    /**
     * Guarda un nuevo cliente en la base de datos.
     *
     * @param cliente objeto cliente a registrar.
     * @return el cliente guardado con su ID generado.
     */
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    /**
     * Actualiza los datos de un cliente existente.
     *
     * @param id identificador del cliente a actualizar.
     * @param clienteActualizado objeto con los nuevos datos.
     * @return el cliente actualizado o {@code null} si no se encontró.
     */
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

    /**
     * Elimina un cliente según su identificador.
     *
     * @param id identificador único del cliente a eliminar.
     */
    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}
