package com.example.Running.service;

import com.example.Running.model.Carrera;
import com.example.Running.model.Inscripcion;
import com.example.Running.repository.CarreraRepository;
import com.example.Running.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> obtenerInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion obtenerInscripcionPorId(Long id) {
        return inscripcionRepository.findById(id).get();
    }

    public void crearInscripcion(Inscripcion inscripcion) {
        Carrera carrera = carreraRepository.findById(inscripcion.getCarrera().getId()).get();
        long totalInscritos = inscripcionRepository.countByCarrera(carrera);
        inscripcion.setCarrera(carrera);
        inscripcion.setDorsal((int) totalInscritos + 1);
        inscripcion.setFechaInscripcion(LocalDateTime.now());

        carrera.setPlazasOcupadas(carrera.getPlazasOcupadas()+1);
        carreraRepository.save(carrera);
        inscripcionRepository.save(inscripcion);
    }
    public void eliminarInscripcion(long id) {
        inscripcionRepository.deleteById(id);
    }

}
