package org.example.jdbc;
import jakarta.persistence.*;
import org.example.Alumno;
import org.example.jpa.pruebapersistencia.ControladoraPersistencia;
import org.example.logica.Carrera;
import org.example.logica.ControladoraLogica;
import java.util.ArrayList;
import java.util.Date;

public class PruebaAlumno {
    public static void main(String[] args) {

        ControladoraLogica control=new ControladoraLogica();

        Carrera carr1=new Carrera(25,"Programacion");
        control.crearCarrera(carr1);
        Carrera carr2=new Carrera(26,"Medicina");
        control.crearCarrera(carr2);

        Alumno alu7=new Alumno(7,"Erick","Santillan", new Date(),carr1);
        control.crearalumno(alu7);

        System.out.println("-----------------------------------");
        System.out.println("--------------Datos alumno-----------");
        Alumno au=control.traerAlumno(7);
        System.out.println("Alumno: "+alu7.getNombre()+" "+alu7.getApellido());
        System.out.println("Cursa la carrera de:"+alu7.getCarre().getNombre());







    }
}

