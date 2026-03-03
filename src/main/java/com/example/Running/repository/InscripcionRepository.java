package com.example.Running.repository;

import com.example.Running.model.Carrera;
import com.example.Running.model.Corredor;
import com.example.Running.model.Evento;
import com.example.Running.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    long countByCarrera(Carrera carrera);

    boolean existsByCorredorAndCarrera(Corredor corredor, Carrera carrera);//asi no puede inscribirse dos veces en la misma carrera

    List<Inscripcion> findByCarreraEvento(Evento evento);

    //añado metodo extra para que un corredor no pueda añadirse a dos carreras del mismo evento
    boolean existsByCorredorAndCarreraEvento(Corredor corredor, Evento evento);
}


