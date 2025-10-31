package com.financorp.serf.factory;

import com.financorp.serf.model.Tecnico;

public class TecnicoFactory {

    public static Tecnico crearTecnico(String nombre, String especialidad, String nivel) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setEspecialidad(especialidad);
        tecnico.setNivel(nivel); // 🔹 ahora funciona
        return tecnico;
    }

    // Ejemplo de creación dinámica según ID
    public static Tecnico crearTecnicoConNivelAutomatico(String nombre, String especialidad, Long idOpcional) {
        Tecnico tecnico = new Tecnico();
        tecnico.setNombre(nombre);
        tecnico.setEspecialidad(especialidad);
        tecnico.setNivel((idOpcional % 2 == 0) ? "Junior" : "Senior"); // 🔹 ahora funciona
        return tecnico;
    }
}
