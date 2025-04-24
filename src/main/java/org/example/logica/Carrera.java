package org.example.logica;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Carrera {
    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Basic
    private String nombre;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Materia>listamaterias;

    public Carrera() {
    }

    public Carrera(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<Materia> getListamaterias() {
        return listamaterias;
    }

    public void setListamaterias(List<Materia> listamaterias) {
        this.listamaterias = listamaterias;
    }
}
