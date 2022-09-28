package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class MapDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//        //creating question
//        Question q1 = new Question();
//        q1.setQuestionId(12134);
//        q1.setQuestion("what is Java");
//        //creating answer
//        Answer answer = new Answer();
//        answer.setAnswerId(343);
//        answer.setAnswer("Java is programming language");
//        answer.setQuestion(q1);
//
//        Answer answer1 = new Answer();
//        answer1.setAnswerId(33);
//        answer1.setAnswer("With the help of java we can create software");
//        answer1.setQuestion(q1);
//
//        Answer answer2 = new Answer();
//        answer2.setAnswerId(363);
//        answer2.setAnswer("Java has different type of frameworks");
//        answer2.setQuestion(q1);
//
//        List<Answer> answers = new ArrayList<>();
//        answers.add(answer);
//        answers.add(answer1);
//        answers.add(answer2);
//
//        q1.setAnswer(answers);
//
//
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
//        session.save(q1);
//        session.save(answer);
//        session.save(answer1);
//        session.save(answer2);
//        //session.save(answers);
//
//
//        tx.commit();



        // fetching....

        Question question = (Question) session.get(Question.class,12134);
        System.out.println(question.getQuestion());
        System.out.println(question.getQuestionId());

        System.out.println(question.getAnswer().size());
        //lazy loading
        for (Answer ans: question.getAnswer()) {
            System.out.println(ans.getAnswer());
        }


        session.close();


    }
}
