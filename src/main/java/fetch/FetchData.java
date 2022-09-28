package fetch;

import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.google.gson.Gson;

public class FetchData {
    public static void main(String[] args) {
        System.out.println("Every thing is ok");

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();

        Student student = s.get(Student.class, 1414);

        Gson gson = new Gson();

        System.out.println(gson.toJson(student));

        s.close();
        sf.close();


    }
}
