package dao;

import model.Connection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ConnectionDao {

    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Connection> findAll() {
        final Query query = entityManager.createQuery("SELECT c FROM Connection c");
        return query.getResultList();
    }

    public Connection update(Connection ai) {
        return entityManager.merge(ai);
    }

    public int save( Connection c) {
        entityManager.persist(c);
        return c.getId();
    }

    public void delete(int id) {
        final Connection c = entityManager.find( Connection.class, id);
        if(c != null) {
            entityManager.remove(c);
        }
    }
    public void deleteAll() {
        final Query query = entityManager.createQuery("DELETE FROM Connection c");
        query.executeUpdate();
    }
}
