package com.example.Running.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name= "Inscripcion")
@Getter @Setter
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    private LocalDateTime fechaInscripcion;
    @ManyToOne
   private  Corredor corredor;
    @ManyToOne
   private  Carrera carrera;
   private int dorsal;



}
