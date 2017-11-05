package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Admins;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AdminsDAO {
    @PersistenceContext(unitName = "gity-db")
    EntityManager em;

    public boolean findAdminByToken(String token) {
        List<Admins> result = em.createQuery(
                "SELECT e FROM Admins e WHERE e.token LIKE :token")
                .setParameter("token", token)
                .setMaxResults(5)
                .getResultList();
        return !result.isEmpty();
    }
}
