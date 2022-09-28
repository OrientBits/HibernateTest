package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        //get, load
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //get-student:
        Student st = (Student) session.load(Student.class,105);
        System.out.println(st);

        Address ad = (Address) session.get(Address.class,2);
        System.out.println(ad.getStreet());

        session.close();
        sessionFactory.close();
    }
}
