package dao;

import model.ChargingPoint;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ChargingPointDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ChargingPoint> findByTown(String town) {
        final Query query = entityManager.createQuery("SELECT cp FROM ChargingPoint cp JOIN AddressInfo ai ON " +
                "cp.address = ai WHERE ai.town = :town");
        return query.getResultList();
    }

    public List<ChargingPoint> findByCountry(String country) {
        final Query query = entityManager.createQuery( "SELECT cp FROM ChargingPoint cp JOIN AddressInfo ai ON " +
                "cp.address = ai JOIN Country c ON ai.country = c WHERE c.title = :title");
        query.setParameter("title", country);
        return query.getResultList();
    }

    public List<ChargingPoint> findAll() {
        final Query query = entityManager.createQuery("SELECT cp FROM ChargingPoint cp");
        return query.getResultList();
    }

    public ChargingPoint update(ChargingPoint cp) {
        return entityManager.merge(cp);
    }

    public int save(ChargingPoint cp) {
        entityManager.persist(cp);
        return cp.getId();
    }

    public void delete(int id) {
        final ChargingPoint cp = entityManager.find(ChargingPoint.class, id);
        if(cp != null) {
            entityManager.remove(cp);
        }
    }
}