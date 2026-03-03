package com.example.Running.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Carrera")
@Getter @Setter
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Integer plazasMax;
    @NotNull
    private Integer plazasOcupadas;
    @Enumerated(EnumType.STRING)
    @NotNull
    private TipoCarrera modalidad;
    @ManyToOne
    private Evento evento;

    public Carrera() {

    }
    public Carrera(Long id,Integer plazasMax, Integer plazasOcupadas,TipoCarrera modalidad) {
        this.id = id;
        this.plazasMax = plazasMax;
        this.plazasOcupadas = plazasOcupadas;
        this.modalidad = modalidad;
    }



}
