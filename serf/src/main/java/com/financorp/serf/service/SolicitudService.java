package com.financorp.serf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financorp.serf.model.Solicitud;
import com.financorp.serf.repository.SolicitudRepository;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    public List<Solicitud> obtenerTodas() {
        return solicitudRepository.findAll();
    }

    public Solicitud guardarSolicitud(Solicitud solicitud) { // 🔹 nombre igual al del Controller
        return solicitudRepository.save(solicitud);
    }

    public Optional<Solicitud> obtenerPorId(Long id) {
        return solicitudRepository.findById(id);
    }

    public void eliminarSolicitud(Long id) { // 🔹 nombre igual al del Controller
        solicitudRepository.deleteById(id);
    }
}
