package pl.infoshareacademy.service;

import pl.infoshareacademy.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDAO {
    @PersistenceContext(unitName = "gity-db")
    EntityManager em;

    public void saveUser(User user) {
        em.persist(user);
    }

    public List<User> findUserByToken(String token) {
        return em.createQuery(
                "SELECT c FROM User c WHERE c.token LIKE :token")
                .setParameter("token", token)
                .getResultList();
    }
}
