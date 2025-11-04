package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Tecnico;
import com.financorp.serf.repository.TecnicoRepository;

/**
 * <h2>Servicio de Gestión de Técnicos</h2>
 *
 * <p>
 * La clase {@code TecnicoService} representa la capa de servicio encargada
 * de manejar la lógica de negocio relacionada con los técnicos del sistema SERF.
 * Su función principal es servir de puente entre el controlador y el repositorio,
 * garantizando una separación clara de responsabilidades.
 * </p>
 *
 * <h3>Patrones de diseño aplicados:</h3>
 * <ul>
 *   <li><b>Service Layer:</b> Separa la lógica de negocio de la lógica de acceso
 *       a datos, permitiendo una arquitectura limpia y escalable.</li>
 *   <li><b>Repository Pattern:</b> Se apoya en {@link TecnicoRepository} para
 *       realizar las operaciones CRUD sobre la entidad {@link Tecnico} sin
 *       exponer los detalles de persistencia.</li>
 *   <li><b>Dependency Injection:</b> El uso de {@link Autowired} permite
 *       inyectar automáticamente el repositorio, reduciendo el acoplamiento.</li>
 * </ul>
 *
 * <h3>Responsabilidades principales:</h3>
 * <ul>
 *   <li>Listar todos los técnicos registrados.</li>
 *   <li>Obtener un técnico específico por su identificador único.</li>
 *   <li>Registrar o actualizar la información de un técnico.</li>
 *   <li>Eliminar técnicos del registro del sistema.</li>
 * </ul>
 *
 * <h3>Ejemplo de uso:</h3>
 * <pre>{@code
 * @Autowired
 * private TecnicoService tecnicoService;
 *
 * // Crear un nuevo técnico
 * Tecnico nuevo = new Tecnico();
 * nuevo.setNombre("Carlos Díaz");
 * nuevo.setEspecialidad("Soporte de sistemas");
 * tecnicoService.guardarTecnico(nuevo);
 *
 * // Listar técnicos
 * List<Tecnico> lista = tecnicoService.obtenerTodos();
 * lista.forEach(t -> System.out.println(t.getNombre()));
 * }</pre>
 *
 */
@Service
public class TecnicoService {

    /** Repositorio que maneja la persistencia de la entidad {@link Tecnico}. */
    @Autowired
    private TecnicoRepository tecnicoRepository;

    /**
     * Obtiene todos los técnicos registrados en el sistema.
     *
     * @return una lista con todas las instancias de {@link Tecnico}.
     */
    public List<Tecnico> obtenerTodos() {
        return tecnicoRepository.findAll();
    }

    /**
     * Busca un técnico específico por su identificador.
     *
     * @param id el identificador único del técnico.
     * @return un {@link Optional} que contiene el técnico si existe, o vacío en caso contrario.
     */
    public Optional<Tecnico> obtenerPorId(Long id) {
        return tecnicoRepository.findById(id);
    }

    /**
     * Guarda un nuevo técnico o actualiza uno existente.
     *
     * @param tecnico la entidad {@link Tecnico} que se desea persistir.
     * @return el técnico guardado con su ID asignado por el sistema.
     */
    public Tecnico guardarTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    /**
     * Elimina un técnico existente del sistema según su identificador.
     *
     * @param id el identificador único del técnico a eliminar.
     */
    public void eliminarTecnico(Long id) {
        tecnicoRepository.deleteById(id);
    }
}
