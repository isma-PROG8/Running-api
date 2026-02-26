package com.example.Running.service;

import com.example.Running.model.Corredor;
import com.example.Running.repository.CorredorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorredorService {
    @Autowired
private CorredorRepository corredorRepository;
public List<Corredor> obtenerTodos(){
	return corredorRepository.findAll();
}
public  Corredor buscarPorId(Long id){
return corredorRepository.findById(id).get();
}
public void agregarCorredor(Corredor corredor){
    corredorRepository.save(corredor);
}
public void eliminarCorredor(Long id){
    corredorRepository.deleteById(id);
}
}
