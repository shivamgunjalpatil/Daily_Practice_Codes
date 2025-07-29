package com.cruds.Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cruds.Entity.Student;

public class Update {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student s = new Student();
		
		int id = 2;
		Student s2 = session.get(Student.class, id);
		s2.setName("shivam");
		s2.setSurname("gunjal");
		s2.setAge(22);
		s2.setEmail("gunjal@gmail.com");
		
		session.merge(s2);
		
		tx.commit();
		session.close();
		sf.close();

	}

}
