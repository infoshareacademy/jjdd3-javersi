package dao;

import model.AddressInfo;
import model.AddressInfo;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class AddressInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AddressInfo> findByCountry(String town) {
        final Query query = entityManager.createQuery("SELECT ai FROM AddressInfo ai JOIN Country c ON " +
                "ai.coutry = c WHERE c.title = :title");
        return query.getResultList();
    }
    

    public List<AddressInfo> findAll() {
        final Query query = entityManager.createQuery("SELECT ai FROM AddressInfo ai");
        return query.getResultList();
    }
    
    public AddressInfo update(AddressInfo ai) {
        return entityManager.merge(ai);
    }

    public int save(AddressInfo ai) {
        entityManager.persist(ai);
        return ai.getId();
    }

    public void delete(int id) {
        final AddressInfo ai = entityManager.find(AddressInfo.class, id);
        if(ai != null) {
            entityManager.remove(ai);
        }
    }
}
