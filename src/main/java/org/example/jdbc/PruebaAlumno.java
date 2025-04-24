package org.example.jdbc;
import jakarta.persistence.*;
import org.example.Alumno;
import org.example.jpa.pruebapersistencia.ControladoraPersistencia;
import org.example.logica.Carrera;
import org.example.logica.ControladoraLogica;
import org.example.logica.Materia;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class PruebaAlumno {
    public static void main(String[] args) {

        ControladoraLogica control = new ControladoraLogica();

// 1. Crear la carrera primero
        Carrera carr1 = new Carrera(25, "Programacion");

// 2. Crear materias Y asignar la carrera a cada una
        Materia mat1 = new Materia(12, "Ingles", "Cuatrimestral");
        Materia mat2 = new Materia(13, "Matematicas", "Cuatrimestral");
        Materia mat3 = new Materia(14, "Programacion", "Cuatrimestral");

        mat1.setCar(carr1);
        mat2.setCar(carr1);
        mat3.setCar(carr1);

// 3. Asignar las materias a la carrera
        List<Materia> listaMaterias = new LinkedList<Materia>();
        listaMaterias.add(mat1);
        listaMaterias.add(mat2);
        listaMaterias.add(mat3);
        carr1.setListamaterias(listaMaterias);

// 4. Guardar la carrera (se recomienda que la relación @OneToMany tenga `cascade = CascadeType.ALL`)
        control.crearCarrera(carr1);

// 5. Crear alumno con esa misma instancia de carrera
        Alumno alu7 = new Alumno(7, "Erick", "Santillan", new Date(), carr1);
        control.crearalumno(alu7);

// 6. Mostrar datos
        System.out.println("-----------------------------------");
        System.out.println("--------------Datos alumno-----------");
        Alumno au = control.traerAlumno(7);
        System.out.println("Alumno: " + au.getNombre() + " " + au.getApellido());
        System.out.println("Cursa la carrera de: " + au.getCarre().getNombre());


    }
}

