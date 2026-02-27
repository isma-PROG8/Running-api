package com.example.Running.controller;


import com.example.Running.model.Carrera;
import com.example.Running.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    @Autowired
    private CarreraService carreraService;
    @GetMapping
    public List<Carrera> obtenerCarreras(){
        return carreraService.obtenerTodasLasCarreras();
    }
    @GetMapping("/{id}")
    public Carrera buscarCarreraPorId(@PathVariable long id){
        return carreraService.obtenerCarreraPorId(id);
    }
    @PostMapping
    public void agregarCarrera(@RequestBody Carrera carrera){
        carreraService.guardarCarrera(carrera);

    }
    @DeleteMapping("/{id}")
    public void eliminarCarrera(@PathVariable long  id){
        carreraService.eliminarCarrera(id);
    }

}
