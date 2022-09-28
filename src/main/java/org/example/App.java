package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // creating student
        Student st = new Student();
        st.setId(105);
        st.setName("Rohit");
        st.setCity("Hazaribagh");
        System.out.println(st);


        //Creating object of address class
        Address ad = new Address();
        ad.setStreet("Street2");
        ad.setCity("Hazaribagh");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1334.234);
        //Reading a image
        FileInputStream fis = new FileInputStream("src/main/resources/jio.png");
        byte[] imageData = new byte[fis.available()];
        fis.read(imageData);
        ad.setImage(imageData);



        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();


        //close the session
        session.close();
        System.out.println("Done....");

    }
}
