package org.example.logica;

import jakarta.persistence.*;

@Entity
public class Materia {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String nombre;
    private String tipo;

    @ManyToOne
    private Carrera car;


    public Materia() {
    }

    public Materia(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Carrera getCar() {
        return car;
    }

    public void setCar(Carrera car) {
        this.car = car;
    }
}

