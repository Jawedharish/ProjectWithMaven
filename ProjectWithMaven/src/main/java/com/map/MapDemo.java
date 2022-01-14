package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // configure file path
		SessionFactory factory = cfg.buildSessionFactory();

		// Creating Question1:

		Question question1 = new Question();
		question1.setQuestionId(123);
		question1.setQuestion("what is java ?");

		// Creating Answer:
		Answer answer = new Answer();
		answer.setAnswerId(321);
		answer.setAnswer("Java is a programming language.");

		question1.setAnswer(answer);

		// Creating Question2:

		Question question2 = new Question();
		question2.setQuestionId(124);
		question2.setQuestion("what is collection Framework ?");

		// Creating Answer2:
		Answer answer2 = new Answer();
		answer2.setAnswerId(421);
		answer2.setAnswer("API to work with object in Java.");

		question2.setAnswer(answer2);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		// objects save:

		session.save(question1);
		session.save(question2);
		tx.commit();
		session.close();

		factory.close();
	}

}
