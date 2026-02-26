package com.example.Running.service;

import com.example.Running.model.Carrera;
import com.example.Running.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository carreraRepository;
    public List<Carrera> obtenerTodasLasCarreras() {
        return carreraRepository.findAll();
    }
    public Carrera obtenerCarreraPorId(Long id) {
        return carreraRepository.findById(id).get();

    }
    public void guardarCarrera(Carrera carrera) {
        carreraRepository.save(carrera);
    }
    public void eliminarCarrera(long id) {
        carreraRepository.deleteById(id);
    }
}
