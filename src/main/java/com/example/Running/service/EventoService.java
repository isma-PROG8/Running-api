package com.example.Running.service;

import com.example.Running.model.Evento;
import com.example.Running.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;
    public List<Evento> obtenerEventos(){
        return eventoRepository.findAll();

    }
    public Evento obtenerEventoPorId(long id){
        return eventoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el evento con el id "+id));
    }
    public Evento guardarEvento(Evento evento){
        return eventoRepository.save(evento);
    }
    public void eliminarEvento(long id){
        eventoRepository.deleteById(id);
    }
}
