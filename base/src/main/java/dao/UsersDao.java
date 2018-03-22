package dao;

import model.UserName;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserName> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM UserNames u");
        return query.getResultList();
    }

    public UserName update(UserName u) {
        return entityManager.merge(u);
    }

    public String save(UserName u) {
        entityManager.persist(u);
        return u.getUserId();
    }

    public void delete(Long id) {
        final UserName u = entityManager.find(UserName.class, id);
        if(u != null) {
            entityManager.remove(u);
        }
    }

    public void deleteAll() {
        final Query query = entityManager.createQuery("DELETE u FROM UserNames u");
        query.executeUpdate();
    }

    public UserName findById(String id) {

    }
}
