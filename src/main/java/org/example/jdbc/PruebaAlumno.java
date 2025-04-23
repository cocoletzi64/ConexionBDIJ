package org.example.jdbc;
import jakarta.persistence.*;
import org.example.Alumno;
import org.example.jpa.pruebapersistencia.ControladoraPersistencia;
import org.example.logica.ControladoraLogica;

import java.util.ArrayList;
import java.util.Date;

public class PruebaAlumno {
    public static void main(String[] args) {

        ControladoraLogica control=new ControladoraLogica();

        Alumno alu=new Alumno(1,"Erick","Santillan", new Date());
        control.crearalumno(alu);

        Alumno alu2=new Alumno(2,"Mario","Cocoletzi",new Date());
        control.crearalumno(alu2);

        Alumno al3=new Alumno(3,"Giovas", "Santillan",new Date());
        control.crearalumno(al3);

        Alumno al4=new Alumno(4,"Luis", "Valladares",new Date());
        control.crearalumno(al4);

        Alumno al5=new Alumno(5,"Dolores", "Campos",new Date());
        control.crearalumno(al5);

        Alumno al6=new Alumno(6,"Vero", "Campos",new Date());
        control.crearalumno(al6);
        control.eliminaralumno(5);
        Alumno au= control.traerAlumno(2);
        au.setApellido("Valladares");
        control.editaralumno(au);
        System.out.println("----------------Busqueda Individual--------------------");
        System.out.println("El alumno es "+au);
        System.out.println("----------------Busqueda Alumnos--------------------");
        ArrayList<Alumno> listaAlumnos=control.traerlistadeAlumnos();
        for(Alumno al:listaAlumnos){
            System.out.println("El alumno es: "+al.toString());
        }



    }
}

