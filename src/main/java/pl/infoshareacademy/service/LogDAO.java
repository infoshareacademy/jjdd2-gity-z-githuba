package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Log;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class LogDAO {
    @PersistenceContext(unitName = "gity-db")
    EntityManager em;

    public Log getLogById(Integer id) {
        Log log = em.find(Log.class, id);
        return log;
    }

    public List<Log> getAllLogs() {
        return em.createQuery("FROM Log").getResultList();
    }

    public List<Log> getLogsByIdRange(Integer min, Integer max) {
        List<Log> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            Log log = em.find(Log.class, i);
            result.add(log);
        }
        return result;
    }

    public List<Log> getLogsByLevel(String level) {
        List<Log> result = em.createQuery("SELECT t FROM TABLE t WHERE t.VALUE = :value1")
                .setParameter("value1", level)
                .getResultList();
        return result;
    }

    public Integer deleteLogById(Integer id) {
        Log log = em.find(Log.class, id);
        em.remove(log);
        return id;
    }

    public void deleteAllLogs() {
        em.createQuery("DELETE FROM Log").executeUpdate();
    }

    public void saveLogToDatabase(String level, String message) {
        Log log = new Log();
        log.setLevel(level);
        log.setMessage(message);
        log.setTime(LocalTime.now());
        em.persist(log);
    }
}
