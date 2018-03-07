package dao;

import model.Country;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Country> findAll() {
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
}
