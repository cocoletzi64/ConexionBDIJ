package org.example.logica;
import org.example.Alumno;
import org.example.jpa.pruebapersistencia.ControladoraPersistencia;

import java.util.ArrayList;
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
}
