package org.example.jpa.pruebapersistencia;
import org.example.Alumno;
import org.example.logica.Carrera;
import org.example.logica.Materia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ControladoraPersistencia {
    AlumnoController alujpa=new AlumnoController();
    CarreraController carrejpa=new CarreraController();
    MateriaController matjpa=new MateriaController();

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

    //Materia

    public void crearMateria(Materia mar) {
        matjpa.create(mar);
    }

    public void elimnarMateria(int id) {
        matjpa.destroy(id);
    }

    public Materia traerMateria(int id) {
       return matjpa.find(id);
    }

    public LinkedList<Materia> traerlistadeMaterias() {
        List<Materia> lista=matjpa.listarTodos();
        LinkedList<Materia> listaMaterias=new LinkedList<Materia>(lista);
        return listaMaterias;

    }

    public void editarMateria(Materia mat) {
        matjpa.edit(mat);
    }
}
