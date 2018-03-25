package dao;

import model.CountryStatistics;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CountryStatisticsDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(CountryStatistics country) {
        entityManager.persist(country);
    }

    public CountryStatistics update(CountryStatistics c) {
        return entityManager.merge(c);
    }

    public CountryStatistics findByName(String country) {
        return entityManager.find(CountryStatistics.class, country);
    }

    public List<CountryStatistics> findAll() {
        final Query query = entityManager.createQuery("SELECT cs FROM CountryStatistics cs");

        return query.getResultList();
    }

    public List<CountryStatistics> findAllOrderByNumberOfVisitsDesc() {
        final Query query = entityManager.createQuery("SELECT cs FROM CountryStatistics cs ORDER BY numberOfVisits DESC");
        return query.getResultList();
    }

    public List<CountryStatistics> findMostChecked() {
        final Query query = entityManager.createQuery("SELECT cs FROM CountryStatistics c WHERE numberOfVisits=(SELECT max(numberOfVisits) FROM CountryStatistics)");

        return query.getResultList();
    }

    public void addToStatistics(String country) {
        final Query query = entityManager.createNativeQuery(
                "INSERT INTO COUNTRY_STATISTICS (name, numberOfVisits) " +
                        "VALUES(:country, 1 ) ON DUPLICATE KEY UPDATE " +
                        "numberOfVisits = numberOfVisits +1");
        query.setParameter("country", country.toUpperCase());
        query.executeUpdate();
        return;
    }
}
