package org.example.jpa.pruebapersistencia;

import jakarta.persistence.*;
import org.example.logica.Carrera;
import org.example.logica.Materia;

import java.util.List;

public class CarreraController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");

    public CarreraController() {
        emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    // Crear nueva carrera
    public void create(Carrera carrera) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Asegurarse de persistir las materias primero si no están ya manejadas
            if (carrera.getListamaterias() != null) {
                for (Materia materia : carrera.getListamaterias()) {
                    if (materia.getId() == 0 || em.find(Materia.class, materia.getId()) == null) {
                        em.persist(materia);
                    } else {
                        em.merge(materia);
                    }
                }
            }

            em.persist(carrera);
            em.getTransaction().commit();
            System.out.println("Carrera creada exitosamente con materias.");
        } catch (PersistenceException e) {
            System.out.println("Error de persistencia: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Editar una carrera existente
    public void edit(Carrera carrera) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Carrera carreraExistente = em.find(Carrera.class, carrera.getId());
            if (carreraExistente != null) {
                carreraExistente.setNombre(carrera.getNombre());

                // Actualizar materias asociadas
                carreraExistente.getListamaterias().clear();
                if (carrera.getListamaterias() != null) {
                    for (Materia materia : carrera.getListamaterias()) {
                        if (materia.getId() == 0 || em.find(Materia.class, materia.getId()) == null) {
                            em.persist(materia);
                        } else {
                            materia = em.merge(materia);
                        }
                        carreraExistente.getListamaterias().add(materia);
                    }
                }

                em.getTransaction().commit();
                System.out.println("Carrera actualizada exitosamente.");
            } else {
                System.out.println("No se encontró la carrera con el ID: " + carrera.getId());
            }
        } finally {
            em.close();
        }
    }

    // Eliminar carrera por ID
    public void destroy(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Carrera carrera = em.find(Carrera.class, id);
            if (carrera != null) {
                em.remove(carrera);
                em.getTransaction().commit();
                System.out.println("Carrera eliminada exitosamente.");
            } else {
                System.out.println("No se encontró la carrera con el ID: " + id);
            }
        } finally {
            em.close();
        }
    }

    // Buscar carrera por ID
    public Carrera find(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Carrera.class, id);
        } finally {
            em.close();
        }
    }

    // Listar todas las carreras
    public List<Carrera> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
        } finally {
            em.close();
        }
    }
}
