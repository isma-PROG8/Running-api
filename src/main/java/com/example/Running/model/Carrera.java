package com.example.Running.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Carrera")
@Getter @Setter
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int plazasMax;
    private int plazasOcupadas;
    private TipoCarrera modalidad;

    public Carrera() {

    }
    public Carrera(Long id,int plazasMax, int plazasOcupadas,TipoCarrera modalidad) {
        this.id = id;
        this.plazasMax = plazasMax;
        this.plazasOcupadas = plazasOcupadas;
        this.modalidad = modalidad;
    }



}
