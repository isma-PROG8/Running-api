package com.example.Running.repository;

import com.example.Running.model.Carrera;
import com.example.Running.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    long countByCarrera(Carrera carrera);


}
