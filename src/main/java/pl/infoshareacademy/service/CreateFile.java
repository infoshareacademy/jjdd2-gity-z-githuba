package pl.infoshareacademy.service;

import pl.infoshareacademy.model.Files;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CreateFile {

    @PersistenceContext(unitName = "example")
    EntityManager em;

    public void test() {

        Files file = new Files();
        file.setFileName("WPISZ SIE");

        em.persist(file);
    }
}
