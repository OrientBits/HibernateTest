package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.beans.Transient;

public class EmbeddedDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Student student1 = new Student();
        student1.setId(12134);
        student1.setName("Priyanka");
        student1.setCity("Hazaribagh");

        Certificate c = new Certificate();
        c.setCourse("Android");
        c.setDuration("2 Months");
        student1.setCertificate(c);

        Student student2 = new Student();
        student2.setId(12135);
        student2.setName("Neha");
        student2.setCity("Chatra");

        Certificate c2 = new Certificate();
        c2.setCourse("Website");
        c2.setDuration("1.5 Months");
        student2.setCertificate(c2);

        Session session = sessionFactory.openSession();
        Transaction transaction =  session.beginTransaction();
        session.save(student1);
        session.save(student2);

        transaction.commit();


    }
}
