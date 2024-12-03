package epicode.it.dao;

import epicode.it.entity.Evento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public void insertAll(List<Evento> lista) {
        em.getTransaction().begin();
        for (Evento e : lista) {
            em.persist(e);
        }
        em.getTransaction().commit();
    }

    public Evento findEventoById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }
}
