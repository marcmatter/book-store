package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee daniel = new Employee();
        daniel.setId(101);
        daniel.setFirstName("Gaurav");
        daniel.setLastName("Chawla");

        session.save(daniel);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }
}
