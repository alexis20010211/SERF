package com.financorp.serf.factory;

import com.financorp.serf.model.Tecnico;

/**
 * Fábrica encargada de la creación de instancias de {@link Tecnico}.
 * <p>
 * Implementa el patrón de diseño <b>Factory Method</b>, permitiendo centralizar
 * y controlar la lógica de creación de técnicos dentro del sistema SERF.
 * </p>
 *
 * <p>Esta clase facilita la creación de técnicos personalizados, ya sea
 * estableciendo manualmente el nivel o generándolo automáticamente.</p>
 *
 * <p>Ejemplo de uso:</p>
 * <pre>{@code
 * Tecnico t1 = TecnicoFactory.crearTecnico("Carlos Pérez", "Redes", "Senior");
 * Tecnico t2 = TecnicoFactory.crearTecnicoConNivelAutomatico("Ana López", "Soporte", 102L);
 * }</pre>
 *
 * @author Alesi
 * @version 1.0
 */
public class TecnicoFactory {

    /**
     * Crea una nueva instancia de {@link Tecnico} con los valores indicados.
     *
     * @param nombre        nombre completo del técnico
     * @param especialidad  área o campo de especialización (por ejemplo: "Redes", "Software", "Hardware")
     * @param nivel         nivel profesional del técnico (por ejemplo: "Junior", "Senior")
     * @return una instancia de {@link Tecnico} con los datos especificados
     */
    public static Tecnico crearTecnico(String nombre, String especialidad, String nivel) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setEspecialidad(especialidad);
        tecnico.setNivel(nivel);
        return tecnico;
    }

    /**
     * Crea una nueva instancia de {@link Tecnico} asignando automáticamente su nivel
     * según una lógica interna basada en el identificador proporcionado.
     * <p>
     * Si el ID es par, el técnico será de nivel <b>Junior</b>; si es impar, será <b>Senior</b>.
     * </p>
     *
     * @param nombre        nombre completo del técnico
     * @param especialidad  especialidad del técnico
     * @param idOpcional    identificador opcional utilizado para determinar el nivel
     * @return una instancia de {@link Tecnico} con el nivel asignado automáticamente
     */
    public static Tecnico crearTecnicoConNivelAutomatico(String nombre, String especialidad, Long idOpcional) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setEspecialidad(especialidad);
        tecnico.setNivel((idOpcional % 2 == 0) ? "Junior" : "Senior");
        return tecnico;
    }
}
