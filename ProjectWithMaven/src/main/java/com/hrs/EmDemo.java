package com.hrs;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); // configure file path
		SessionFactory factory = cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(1412);
		student1.setName("Azhar");
		student1.setCity("Mumbai");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 Months");
		
		student1.setCertificate(certificate);
		
		Student student2=new Student();
		student2.setId(1342);
		student2.setName("Azaz");
		student2.setCity("Lko");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("1.5 Months");
		
		student2.setCertificate(certificate1);
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		//objects save:
		
		session.save(student1);
		session.save(student2);
		tx.commit();
		session.close();
		factory.close();
	}

}
