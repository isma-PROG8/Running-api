package com.example.Running.controller;

import com.example.Running.model.Carrera;
import com.example.Running.model.Evento;
import com.example.Running.model.Inscripcion;
import com.example.Running.service.CarreraService;
import com.example.Running.service.EventoService;

import com.example.Running.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @Autowired
    private InscripcionService inscripcionService;
    @Autowired
    private CarreraService carreraService;
    @GetMapping
    public List<Evento> obtenerEventos()
    {
        return eventoService.obtenerEventos();
    }
    @GetMapping("/{id}")
    public Evento  obtenerEventoPorId(@PathVariable Long id){
        return eventoService.obtenerEventoPorId(id);
    }
    @PostMapping()
    public Evento  guardarEvento(@Valid @RequestBody Evento evento){
       return  eventoService.guardarEvento(evento);
    }
    @GetMapping("/{id}/inscripciones")
    public List<Inscripcion> obtenerInscripcionesPorEvento(@PathVariable Long id) {
        return inscripcionService.obtenerInscripcionesPorEvento(id);
    }
    @GetMapping("/{id}/carreras")
    public List<Carrera> obtenerCarrerasPorEvento(@PathVariable Long id) {
        return carreraService.obtenerCarrerasPorEvento(id);
    }
    @DeleteMapping("/{id}")
    public void eliminarEventoPorId(@PathVariable Long id){
        eventoService.eliminarEvento(id);
    }


}
