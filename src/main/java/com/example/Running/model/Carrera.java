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
    private Integer plazasMax;
    private Integer plazasOcupadas;
    @Enumerated(EnumType.STRING)
    private TipoCarrera modalidad;

    public Carrera() {

    }
    public Carrera(Long id,Integer plazasMax, Integer plazasOcupadas,TipoCarrera modalidad) {
        this.id = id;
        this.plazasMax = plazasMax;
        this.plazasOcupadas = plazasOcupadas;
        this.modalidad = modalidad;
    }



}
