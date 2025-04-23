package org.example.jpa.pruebapersistencia;
import org.example.Alumno;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    AlumnoController alujpa=new AlumnoController();

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
}
