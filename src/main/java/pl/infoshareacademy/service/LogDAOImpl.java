package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Log;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

public class LogDAOImpl implements LogDAO {
    @PersistenceContext(unitName = "gity-db")
    EntityManager em;

    public LogDAOImpl() {
    }

    @Override
    public Log getLogById(Integer id) {
        /*Log log = em.find(Log.class, id);
        return log;*/
        Log log = (Log) em.createQuery("SELECT id, message, time FROM Log WHERE id=" + id);
        return log;
    }

    @Override
    public List<Log> getAllLogs() {
        return em.createQuery("FROM Log").getResultList();

    }

    @Override
    public List<Log> getLogsByIdRange(Integer min, Integer max) {
        List<Log> result = Collections.emptyList();
        for (int i = min; i <= max; i++) {
            Log log = em.find(Log.class, i);
            result.add(log);
        }
        return result;

    }

    @Override
    public List<Log> getLogsByLevel(String level) {
        List<Log> result = em.createQuery("SELECT t FROM TABLE t WHERE t.VALUE = :value1")
                .setParameter("value1", level)
                .getResultList();
        return result;
    }

    @Override
    public Integer deleteLogById(Integer id) {
        Log log = em.find(Log.class, id);
        em.remove(log);
        return id;
    }

    @Override
    public void deleteAllLogs() {
        em.createQuery("DELETE FROM Log").executeUpdate();
    }
}

