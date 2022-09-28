package states;

import org.example.Certificate;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

    public static void main(String[] args) {

        System.out.println("Hello World");

       //State of Hibernate objects: Practical
        // Transient -> Persistent -> Detached -> Removed

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();


        //Student object creating
        Student student = new Student();
        student.setId(1414);
        student.setName("Rohit Singh");
        student.setCity("Hazaribagh");
        student.setCertificate(new Certificate("java","Hibernate"));
        // Student: Transient state


        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        //Student: Persistent state
        student.setName("Abhishek");
        tx.commit();

        session.close();

        //Student: Detached State
        student.setName("Hello Name");
        sessionFactory.close();

       //Student: Removed State
        // get the data and delete the data with get/load method -> Session#delete() or Session#remove()
    }
}
