package com.example.Running.service;

import com.example.Running.model.Carrera;
import com.example.Running.model.Evento;
import com.example.Running.repository.CarreraRepository;
import com.example.Running.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventoService {
    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private EventoRepository eventoRepository;
    public List<Evento> obtenerEventos(){
        return eventoRepository.findAll();

    }
    public Evento obtenerEventoPorId(long id){
        return eventoRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el evento con el id "+id));
    }
    public Evento guardarEvento(Evento evento){
        Evento eventoGuardado = eventoRepository.save(evento);

        if(evento.getCarreras() != null) {
            for(Carrera carrera : evento.getCarreras()) {
                carrera.setEvento(eventoGuardado);
                carreraRepository.save(carrera);
            }
        }
        return eventoGuardado;
    }
    public void eliminarEvento(long id){
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No existe el evento con id " + id));

        carreraRepository.deleteAll(evento.getCarreras());
        eventoRepository.deleteById(id);
    }
}
