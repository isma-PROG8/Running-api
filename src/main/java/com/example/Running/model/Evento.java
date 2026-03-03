package com.example.Running.model;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Evento")
@Getter @Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nombre;
    @NotNull
    private LocalDateTime fecha;
    @NotBlank
    private String ciudad;
    private Boolean activo;
    @OneToMany(mappedBy = "evento")
    private List<Carrera> carreras;

    public Evento() {

    }


}
