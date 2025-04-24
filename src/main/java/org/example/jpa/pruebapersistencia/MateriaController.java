package org.example.jpa.pruebapersistencia;

import jakarta.persistence.*;
import org.example.logica.Materia;

import java.util.List;

public class MateriaController {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");

    public MateriaController() {
        emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
    }

    // Crear nueva materia
    public void create(Materia materia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(materia);
            em.getTransaction().commit();
            System.out.println("Materia creada exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error de persistencia: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    // Editar una materia existente
    public void edit(Materia materia) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Materia materiaExistente = em.find(Materia.class, materia.getId());
            if (materiaExistente != null) {
                materiaExistente.setNombre(materia.getNombre());
                materiaExistente.setTipo(materia.getTipo());
                em.getTransaction().commit();
                System.out.println("Materia actualizada exitosamente.");
            } else {
                System.out.println("No se encontró la materia con el ID: " + materia.getId());
            }
        } finally {
            em.close();
        }
    }

    // Eliminar materia por ID
    public void destroy(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Materia materia = em.find(Materia.class, id);
            if (materia != null) {
                em.remove(materia);
                em.getTransaction().commit();
                System.out.println("Materia eliminada exitosamente.");
            } else {
                System.out.println("No se encontró la materia con el ID: " + id);
            }
        } finally {
            em.close();
        }
    }

    // Buscar materia por ID
    public Materia find(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            em.close();
        }
    }

    // Listar todas las materias
    public List<Materia> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT m FROM Materia m", Materia.class).getResultList();
        } finally {
            em.close();
        }
    }
}

