package dao;

import model.User;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateful
public class UsersDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        final Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    public User update(User u) {
        return entityManager.merge(u);
    }

    public String save(User u) {
        entityManager.persist(u);
        return u.getUserId();
    }

    public void delete(Long id) {
        final User u = entityManager.find(User.class, id);
        if(u != null) {
            entityManager.remove(u);
        }
    }

    public User findById(String id) {
        return entityManager.find(User.class, id);
    }
}
