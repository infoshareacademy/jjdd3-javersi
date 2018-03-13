package dao;

import model.PromotedChargingPoint;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PromotedChargingPointDao {

    @PersistenceContext
    private EntityManager entityManager;

    public int save(PromotedChargingPoint pcp) {
        entityManager.persist(pcp);
        return pcp.getChargingPointId();
    }

    public void delete(int chargingPointId) {
        final PromotedChargingPoint pcp = entityManager.find(PromotedChargingPoint.class, chargingPointId);
        if(pcp != null) {
            entityManager.remove(pcp);
        }
    }

    public PromotedChargingPoint findById(Integer id) {
        return entityManager.find(PromotedChargingPoint.class, id);
    }

    public List<PromotedChargingPoint> findAll() {
        final Query query = entityManager.createQuery("SELECT p FROM PromotedChargingPoint p");
        return query.getResultList();
    }
}

