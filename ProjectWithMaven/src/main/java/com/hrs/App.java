package com.hrs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args ) throws FileNotFoundException, IOException
    {
        System.out.println( "Project Started...." );
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml"); // config file path
        SessionFactory factory=cfg.buildSessionFactory();
        //Creating Student
        Student st=new Student();
        st.setId(102);
        st.setName("Smith");
        st.setCity("Lucknow");
        System.out.println(st);
        
        //Creating object of address class
        Address address=new Address();
        address.setStreet("street1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(123124.1234);
        
        //Reading image
		FileInputStream fileInputStream = new FileInputStream("src/main/java/image.png");
		byte[] data=new byte[fileInputStream.available()];
		fileInputStream.read(data);
		address.setImage(data);
		
        Session session=factory.openSession();
        
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(address);
        tx.commit();
        session.close();
        factory.close();
        System.out.println("Done....");
    }
}
