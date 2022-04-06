package com.jef.demo;

import com.jef.demo.entity.Message;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldJPATest {

    private static EntityManagerFactory emf;

    private Message msg;

    @BeforeAll
    private static void initalConfig() {
        emf = Persistence.createEntityManagerFactory("ch02.ex01");
    }

    @BeforeEach
    private void initBeans() {
        msg = new Message();
    }

    @Test
    void storeLoadMessage() {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        msg.setText("Hello World!");

        em.persist(msg);
        em.getTransaction().commit();

        em.getTransaction().begin();
        List<Message> messages = em.createQuery("select m from Message m").getResultList();

        messages.get(messages.size()-1).setText("Hello World from JPA!");

        em.getTransaction().commit();

        assertAll(() -> assertEquals(1, messages.size()),
                () -> assertEquals("Hello World from JPA!", messages.get(0).getText()));

        em.close();
        emf.close();
    }
}
