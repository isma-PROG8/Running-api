package com.example.Running.controller;

import com.example.Running.model.Inscripcion;
import com.example.Running.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;
    @GetMapping
    public List<Inscripcion> obtenerInscripciones(){
        return inscripcionService.obtenerInscripciones();
    }
    @GetMapping("/{id}")
    public Inscripcion buscarInscripcionPorId(@PathVariable long id){
        return inscripcionService.obtenerInscripcionPorId(id);
    }
    @PostMapping
    public void agregarInscripcion(@RequestBody Inscripcion inscripcion){
        inscripcionService.crearInscripcion(inscripcion);
    }
    @DeleteMapping("/{id}")
    public void eliminarInscripcion(@PathVariable long  id){
        inscripcionService.eliminarInscripcion(id);
    }
}
