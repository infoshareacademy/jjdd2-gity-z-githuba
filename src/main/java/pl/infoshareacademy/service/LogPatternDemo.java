package pl.infoshareacademy.service;

import com.mysql.cj.xdevapi.XSessionFactory;
import pl.infoshareacademy.model.Log;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.security.auth.login.Configuration;
import javax.transaction.Transaction;

public class LogPatternDemo {
    @PersistenceContext(unitName = "example")
    EntityManager em;

    public static void main(String [] args) {
        LogDAO logDAO = new LogDAOImpl();

        //Print all logs
        for (Log log : logDAO.getAllLog()) {
            System.out.println("Log: [ID: " + log.getId() + "]     " + log.getMessage());
        }
    }

    public void saveLog() {
        LogDAO logDAO = new LogDAOImpl();

        em.getTransaction().begin();
        if (em.getTransaction().isActive()) {
            em.persist(logDAO);
            em.getTransaction().commit();
        } else {
            System.out.println("Current transaction state: " + em.getTransaction().isActive());
        }
    }
}
