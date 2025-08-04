package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity1.Book;
import entity1.Library;


public class Main {

	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure()
	            .addAnnotatedClass(Library.class)
	            .addAnnotatedClass(Book.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction tx = session.beginTransaction();
	        
	        Library lib = new Library();
	        lib.setLibraryName("Central");
	        
	        
	        
	        Book b = new Book();
	        b.setBookId(1001);
	        b.setBookName("DSA");
	        b.setLibrary(lib);
	        
	        Book b1 = new Book();
	        b1.setBookId(1002);
	        b1.setBookName("OOPS");
	        b1.setLibrary(lib);
	        
	        Book b2 = new Book();
	        b2.setBookId(1003);
	        b2.setBookName("Aptitude");
	        b2.setLibrary(lib);
	       
	        
	        List<Book> list = new ArrayList<>();
	        list.add(b);
	        list.add(b1);
	        list.add(b2);
	        
	        lib.setBook(list);
	        session.persist(lib);
	        
	        tx.commit();
	        session.close();
	        
	        
	        
	        

	}

}
