package org.example.jpa.pruebapersistencia;
import org.example.Alumno;
import org.example.logica.Carrera;

import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    AlumnoController alujpa=new AlumnoController();
    CarreraController carrejpa=new CarreraController();

    public void crearAlumno(Alumno alu) {
        alujpa.create(alu);
    }

    public void elimnaralumno(int id) {
        alujpa.destroy(id);
    }

    public Alumno traeralumno(int id){
        return alujpa.find(id);
    }

    public ArrayList<Alumno> traerlistaalumnos() {
        List<Alumno> listita=alujpa.listarTodos();
        ArrayList<Alumno> listaAlumnos=new ArrayList<Alumno>(listita);
        return listaAlumnos;
    }
    public void editarAlumno(Alumno alu) {
        alujpa.edit(alu);
    }

    //Carrera

    public void crearCarrera(Carrera car) {
        carrejpa.create(car);

    }

    public void elimnarcCarrera(int id) {
        carrejpa.destroy(id);
    }

    public Carrera traerCarrera(int id) {
        return carrejpa.find(id);
    }

    public void editarCarrera(Carrera car) {
        carrejpa.edit(car);
    }

    public ArrayList<Carrera> traerlistadeCarreras() {
        List<Carrera> listi=carrejpa.listarTodos();
        ArrayList<Carrera> listaCarreras=new ArrayList<Carrera>(listi);
        return listaCarreras;
    }
}
