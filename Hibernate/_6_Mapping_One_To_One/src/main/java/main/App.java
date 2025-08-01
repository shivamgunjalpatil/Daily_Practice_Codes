package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Answer;
import entity.Quation;

public class App {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure()
            .addAnnotatedClass(Quation.class)
            .addAnnotatedClass(Answer.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Answer ans = new Answer();
        ans.setAnswer("Java is object oriented language");

        Quation que = new Quation();
        que.setQuation("What is Java?");
        que.setAns(ans);

        session.persist(que); // Answer will auto-save because of CascadeType.ALL

        tx.commit();
        session.close();
        sf.close();

        System.out.println("✅ Inserted successfully!");
    }
}
