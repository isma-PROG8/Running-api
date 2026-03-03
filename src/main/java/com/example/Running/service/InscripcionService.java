package com.example.Running.service;

import com.example.Running.model.Carrera;
import com.example.Running.model.Corredor;
import com.example.Running.model.Evento;
import com.example.Running.model.Inscripcion;
import com.example.Running.repository.CarreraRepository;
import com.example.Running.repository.CorredorRepository;
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
    @Autowired
    private CorredorRepository corredorRepository;

    public List<Inscripcion> obtenerInscripciones() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion obtenerInscripcionPorId(Long id) {
        return inscripcionRepository.findById(id).orElseThrow(()-> new RuntimeException("No existe la inscripcion con id "+id));
    }

    public void crearInscripcion(Inscripcion inscripcion) {
        Carrera carrera = carreraRepository.findById(inscripcion.getCarrera().getId()).orElseThrow(()->new RuntimeException("No existe la carrera con id" +inscripcion.getCarrera().getId() ));
        Corredor corredor = corredorRepository.findById(inscripcion.getCorredor().getId())
                .orElseThrow(() -> new RuntimeException("No existe el corredor con id " + inscripcion.getCorredor().getId()));

        if(carrera.getPlazasOcupadas()>=carrera.getPlazasMax()){
            throw new RuntimeException("No quedan plazas disponibles");
        }
        if (inscripcionRepository.existsByCorredorAndCarrera(corredor,carrera)) {
            throw new RuntimeException("El corredor ya esta inscrito en la carrera");
        }
        if(inscripcionRepository.existsByCorredorAndCarreraEvento(corredor, carrera.getEvento())){
            throw new RuntimeException("El corredor ya esta inscrito en este evento");
        }

        long totalInscritos = inscripcionRepository.countByCarrera(carrera);
        inscripcion.setCarrera(carrera);
        inscripcion.setDorsal((int) totalInscritos + 1);
        inscripcion.setFechaInscripcion(LocalDateTime.now());

        carrera.setPlazasOcupadas(carrera.getPlazasOcupadas()+1);
        carreraRepository.save(carrera);
        inscripcionRepository.save(inscripcion);

    }
    public List<Inscripcion> obtenerInscripcionesPorEvento(Long eventoId) {
        Evento evento=new Evento();
        evento.setId(eventoId);
        return inscripcionRepository.findByCarreraEvento(evento);

    }
    public void eliminarInscripcion(long id) {
        inscripcionRepository.deleteById(id);
    }

}
