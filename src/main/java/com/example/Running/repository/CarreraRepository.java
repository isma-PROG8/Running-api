package com.example.Running.repository;

import com.example.Running.model.Carrera;
import com.example.Running.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {
    List<Carrera> findByEvento( Evento evento);
}
