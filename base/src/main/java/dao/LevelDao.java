package dao;

import model.Level;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LevelDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Level> findAll() {
        final Query query = entityManager.createQuery("SELECT l FROM Level l");
        return query.getResultList();
    }

    public Level update(Level l) {
        return entityManager.merge(l);
    }

    public int save( Level l) {
        entityManager.persist(l);
        return l.getId();
    }

    public void delete(int id) {
        final Level l = entityManager.find( Level.class, id);
        if(l != null) {
            entityManager.remove(l);
        }
    }
    public void deleteAll() {
        final Query query = entityManager.createQuery("DELETE FROM Level l");
        query.executeUpdate();
    }
}