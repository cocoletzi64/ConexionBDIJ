package org.example.jdbc;
import jakarta.persistence.*;
import org.example.Alumno;

public class PruebaAlumno {
    public static void main(String[] args) {

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
                EntityManager em = emf.createEntityManager();

                try {
                    em.getTransaction().begin();
                    Alumno alumno = new Alumno();
                    alumno.setID(1);
                    alumno.setNombre("Erick");

                    em.merge(alumno);

                    em.getTransaction().commit();
                    System.out.println("Paciente guardado con éxito.");
                } catch (Exception e) {
                    em.getTransaction().rollback();
                    e.printStackTrace();
                } finally {
                    em.close();
                    emf.close();
                }
            }
        }

