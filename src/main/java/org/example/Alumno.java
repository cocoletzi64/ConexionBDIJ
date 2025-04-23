package org.example;
import jakarta.persistence.*;
import org.example.logica.Carrera;

import java.util.Date;
@Entity
public class Alumno {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;
    @Basic
    private String nombre;
    private String apellido;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToOne
    private Carrera carre;

    public Alumno() {
    }

    public Alumno(int ID, String nombre, String apellido, Date fecha, Carrera carre) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.carre = carre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Carrera getCarre() {
        return carre;
    }

    public void setCarre(Carrera carre) {
        this.carre = carre;
    }

    @Override
    public String toString() {
        return
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha=" + fecha ;
    }
}
