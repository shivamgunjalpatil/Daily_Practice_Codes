package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity1.Book;
import entity1.Library;
import entity2.Courses;
import entity2.Trainer;

public class MainMethod {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure()
	            .addAnnotatedClass(Trainer.class)
	            .addAnnotatedClass(Courses.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Trainer t = new Trainer();
	        t.setTrainerName("Shubham Barse");
	       
	        Courses c = new Courses();
	        c.setCourseId(501);
	        c.setCourseName("java");
	        c.setTrainer(t);
	        
	        Courses c1 = new Courses();
	        c1.setCourseId(502);
	        c1.setCourseName("python");
	        c1.setTrainer(t);
	        
	        List<Courses> list = new ArrayList<>();
	        list.add(c1);
	        list.add(c);
	        
	        t.setCourses(list);
	        
	        session.persist(t);
	        tx.commit();
	        session.close();

	}

}
