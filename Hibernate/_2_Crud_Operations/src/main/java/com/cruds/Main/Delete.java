package com.cruds.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cruds.Entity.Student;

public class Delete {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		int id = 1;
		Student s1 = session.get(Student.class, id);
		
		session.remove(s1);
		
		System.out.println("Record deleted Successfully");
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
