package com.map.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();

        Emp e1 = new Emp();
        Emp e2 = new Emp();
        e1.setId(34);
        e1.setName("Ram");
        e2.setId(35);
        e2.setName("Shyam");
        List<Emp> empList = new ArrayList<>();
        empList.add(e1);
        empList.add(e2);

        Project p1 = new Project();
        Project p2 = new Project();
        p1.setId(12121);
        p1.setProjectName("Library management system");
        p2.setId(14214);
        p2.setProjectName("Chat bot");
        List<Project> projectList = new ArrayList<>();
        projectList.add(p1);
        projectList.add(p2);


        e1.setProjectList(projectList);
        p2.setEmpList(empList);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);


        tx.commit();
        factory.close();

    }
}
