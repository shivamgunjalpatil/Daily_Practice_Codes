package com.cruds.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cruds.Entity.Student;

public class Insert {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure();
		
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student s = new Student();
		s.setName("mahesh");
		s.setSurname("sapte");
		s.setAge(23);
		s.setEmail("mahi@gmail.com");
		
		session.persist(s);
		
		System.out.println("Record Inserted Succesfully");
		
		tx.commit();
		session.close();
		sf.close();

	}

}
