package com.hrs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		// get , load method
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // configure file path
		SessionFactory factory = cfg.buildSessionFactory();
		// get.student:102
		Session session = factory.openSession();
		/*
		 * Student student = (Student) session.get(Student.class, 102);
		 * System.out.println(student);
		 */

		Student student = (Student) session.load(Student.class, 102);
		System.out.println(student);

		Address address = (Address) session.get(Address.class, 1);
		System.out.println(address.getStreet() + " : " + address.getCity());

		session.close();
		factory.close();
	}

}
