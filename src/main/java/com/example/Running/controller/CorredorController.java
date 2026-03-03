package com.example.Running.controller;


import com.example.Running.model.Corredor;
import com.example.Running.service.CorredorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/corredores")
public class CorredorController {
    @Autowired
private CorredorService corredorService;
    @GetMapping
    public List<Corredor> obtenerCorredores(){
        return corredorService.obtenerTodos();
    }
    @GetMapping("/{id}")
    public Corredor buscarPorId(@PathVariable long id){
        return corredorService.buscarPorId(id);
    }

    @PostMapping()
    public void agregarCorredor(@Valid @RequestBody Corredor corredor){
        corredorService.agregarCorredor(corredor);
    }
    @DeleteMapping("/{id}")
    public void eliminarCorredor(@PathVariable long  id){
        corredorService.eliminarCorredor(id);
    }




}
