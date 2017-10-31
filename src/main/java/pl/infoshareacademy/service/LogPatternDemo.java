package pl.infoshareacademy.service;

import com.mysql.cj.xdevapi.XSessionFactory;
import pl.infoshareacademy.model.Log;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.Configuration;
import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Stateless
public class LogPatternDemo {
    @PersistenceContext(unitName = "gity-db")
    EntityManager em;

    public void saveLog() {
        for (int i = 0; i < 100; i++) {
            LocalDate date = LocalDate.now();
            Log log = new Log("Log number: " + i, date);
            em.persist(log);
        }
    }

    public void deleteLog(Integer id) {
        Log log = em.find(Log.class, id);
        em.remove(log);
    }

    public List<Log>  getAllLogs() {
        return em.createQuery("FROM Log").getResultList();

    }

    public List<Log> getLogRange(int start, int end) {
        List<Log> result = Collections.emptyList();
        for (int i = start; i <= end; i++) {
            Log log = em.find(Log.class, i);
            result.add(log);
        }
        return result;
    }
}

