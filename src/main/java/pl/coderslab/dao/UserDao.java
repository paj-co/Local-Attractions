package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public boolean searchUserByEmail(String email) {
        System.out.println("UserDao 1 " + email + " ------------------------");
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email");
        query.setParameter("email", email);
        System.out.println("UserDao 2  ------------------------");
        List<User> users = query.getResultList();
        if (users.size() > 0) {
            return true;
        }
        return false;
    }

}
