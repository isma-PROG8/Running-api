package com.example.Running.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "Corredor")
@Getter @Setter
public class Corredor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String dni;
    private String telefono;
    private String correo;
    public Corredor() {

    }
    public Corredor(String nombre, String dni, String telefono,String correo){
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;

    }
}
