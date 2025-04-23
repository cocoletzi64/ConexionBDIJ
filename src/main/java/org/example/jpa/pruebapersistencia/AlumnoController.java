package org.example.jpa.pruebapersistencia;

import jakarta.persistence.*;
import org.example.Alumno;
import org.example.logica.Carrera;


import java.util.List;

public class AlumnoController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");

    public AlumnoController() {
        emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    public void create(Alumno alumno) {
        EntityManager em = emf.createEntityManager();
        try {
            // Verificar si ya existe un alumno con el mismo ID
            TypedQuery<Alumno> query = em.createQuery(
                    "SELECT a FROM Alumno a WHERE a.ID = :ID", Alumno.class
            );
            query.setParameter("ID", alumno.getID());

            if (!query.getResultList().isEmpty()) {
                System.out.println("El alumno ya existe en la base de datos.");
                return; // No lo creamos
            }

            // Verificar si la carrera asociada existe (si aplica)
            if (alumno.getCarre() != null) {
                Carrera carrera = em.find(Carrera.class, alumno.getCarre().getId());
                if (carrera == null) {
                    System.out.println("La carrera asociada no existe.");
                    return;
                }
                alumno.setCarre(carrera); // Asegúrate de asociar la carrera correctamente
            }

            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            System.out.println("Alumno creado exitosamente.");
        } catch (jakarta.persistence.PersistenceException e) {
            if (e.getCause() instanceof java.sql.SQLIntegrityConstraintViolationException) {
                System.out.println("Error al insertar el alumno: Ya existe un alumno con el mismo ID.");
            } else {
                System.out.println("Error de persistencia: " + e.getMessage());
            }
        } finally {
            em.close();
        }
    }

    public void edit(Alumno alumno) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Alumno alumnoExistente = em.find(Alumno.class, alumno.getID());
            if (alumnoExistente != null) {
                // Si es necesario actualizar la carrera
                if (alumno.getCarre() != null) {
                    Carrera carrera = em.find(Carrera.class, alumno.getCarre().getId());
                    if (carrera != null) {
                        alumnoExistente.setCarre(carrera);
                    } else {
                        System.out.println("La carrera asociada no existe.");
                        return;
                    }
                }

                alumnoExistente.setNombre(alumno.getNombre());
                alumnoExistente.setApellido(alumno.getApellido());
                em.getTransaction().commit();
            } else {
                System.out.println("No se encontró el alumno con el ID: " + alumno.getID());
            }
        } finally {
            em.close();
        }
    }

    public void destroy(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Alumno alumno = em.find(Alumno.class, id);
            if (alumno != null) {
                em.remove(alumno);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Alumno find(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Alumno.class, id);
        } finally {
            em.close();
        }
    }

    public List<Alumno> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Alumno a", Alumno.class).getResultList();
        } finally {
            em.close();
        }
    }
}

