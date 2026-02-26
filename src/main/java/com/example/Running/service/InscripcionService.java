package com.example.Running.service;

import com.example.Running.model.Inscripcion;
import com.example.Running.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    public List<Inscripcion> obtenerInscripciones() {
        return inscripcionRepository.findAll();
    }
    public Inscripcion obtenerInscripcionPorId(Long id) {
        return inscripcionRepository.findById(id).get();
    }
    public void crearInscripcion(Inscripcion inscripcion) {
        inscripcionRepository.save(inscripcion);
    }
    public void eliminarInscripcion(long id) {
        inscripcionRepository.deleteById(id);
    }

}
