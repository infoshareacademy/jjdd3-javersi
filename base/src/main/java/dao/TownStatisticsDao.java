package dao;

import model.TownStatistics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class TownStatisticsDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(TownStatistics city) {
        entityManager.persist(city);
    }

    public TownStatistics update(TownStatistics c) {
        return entityManager.merge(c);
    }

    public TownStatistics findByName(String city) {
        return entityManager.find(TownStatistics.class, city);
    }

    public List<TownStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT ts FROM TownStatistics ts");

        return query.getResultList();
    }

    public List<TownStatistics> findAllOrderByNumberOfVisitsDesc() {
        final Query query = entityManager.createQuery("SELECT ts FROM TownStatistics ts ORDER BY numberOfVisits DESC");
        return query.getResultList();
    }

    public List<TownStatistics> findMostChecked() {
        final Query query = entityManager.createQuery("SELECT ts FROM TownStatistics ts WHERE numberOfVisits=(SELECT max(numberOfVisits) FROM TownStatistics)");

        return query.getResultList();
    }

    public void addToStatistics(String town) {
        final Query query = entityManager.createNativeQuery(
                "INSERT INTO TOWN_STATISTICS (name, numberOfVisits) " +
                "VALUES(:town, 1 ) ON DUPLICATE KEY UPDATE " +
                "numberOfVisits = numberOfVisits +1");
        query.setParameter("town", town);
        query.executeUpdate();
        return;
    }
}
