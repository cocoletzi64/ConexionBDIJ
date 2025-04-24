package org.example.logica;
import org.example.Alumno;
import org.example.jpa.pruebapersistencia.ControladoraPersistencia;

import java.util.ArrayList;
import java.util.LinkedList;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();

    public void crearalumno(Alumno alu){
        controlPersis.crearAlumno(alu);
    }
    public void eliminaralumno(int id){
        controlPersis.elimnaralumno(id);

    }
    public Alumno traerAlumno(int id){
        return controlPersis.traeralumno(id);
    }
    public ArrayList<Alumno> traerlistadeAlumnos(){
        return controlPersis.traerlistaalumnos();
    }
    public void editaralumno(Alumno alu){
        controlPersis.editarAlumno(alu);
    }
    //Carrera
    public void crearCarrera(Carrera car){
        controlPersis.crearCarrera(car);
    }
    public void eliminaCarrera(int id){
        controlPersis.elimnarcCarrera(id);

    }
    public Carrera traerCarrera(int id){
        return controlPersis.traerCarrera(id);
    }
    public ArrayList<Carrera> traerlistadeCarreras(){
        return controlPersis.traerlistadeCarreras();
    }
    public void editarCarrera(Carrera car){
        controlPersis.editarCarrera(car);
    }

    //Materia

    public void crearMatereria(Materia mar){
        controlPersis.crearMateria(mar);
    }
    public void eliminarMateria(int id){
        controlPersis.elimnarMateria(id);

    }
    public Materia traerMateria(int id){
        return controlPersis.traerMateria(id);
    }
    public LinkedList<Materia> traerlistadeMaterias(){
        return controlPersis.traerlistadeMaterias();
    }
    public void editarMateria(Materia mat){
        controlPersis.editarMateria(mat);
    }

}
