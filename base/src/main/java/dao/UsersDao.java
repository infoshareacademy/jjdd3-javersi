package dao;

import model.UserNames;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserNames> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM UserNames u");
        return query.getResultList();
    }

    public UserNames update(UserNames u) {
        return entityManager.merge(u);
    }

    public String save(UserNames u) {
        entityManager.persist(u);
        return u.getUserId();
    }

    public void delete(Long id) {
        final UserNames u = entityManager.find(UserNames.class, id);
        if(u != null) {
            entityManager.remove(u);
        }
    }

    public void deleteAll() {
        final Query query = entityManager.createQuery("DELETE u FROM UserNames u");
        query.executeUpdate();
    }
}
