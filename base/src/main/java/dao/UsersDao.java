package dao;

import model.Country;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT c FROM Country c");
        return query.getResultList();
    }

    public Country update(Country c) {
        return entityManager.merge(c);
    }

    public int save(Country c) {
        entityManager.persist(c);
        return c.getId();
    }

    public void delete(int id) {
        final Country c = entityManager.find(Country.class, id);
        if(c != null) {
            entityManager.remove(c);
        }
    }

    public void deleteAll() {
        final Query query = entityManager.createQuery("DELETE FROM Country c");
        query.executeUpdate();
    }
}
