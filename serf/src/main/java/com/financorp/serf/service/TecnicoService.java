package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Tecnico;
import com.financorp.serf.repository.TecnicoRepository;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> obtenerTodos() {
        return tecnicoRepository.findAll();
    }

    public Optional<Tecnico> obtenerPorId(Long id) {
        return tecnicoRepository.findById(id); // Devuelve Optional<Tecnico>
    }

    public Tecnico guardarTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public void eliminarTecnico(Long id) {
        tecnicoRepository.deleteById(id);
    }
}
