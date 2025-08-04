package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Product;
import entity.Users;



public class MainApp {
	public static void main(String[] args) {
        Configuration cfg = new Configuration().configure()
            .addAnnotatedClass(Product.class)
            .addAnnotatedClass(Users.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        Product p1 = new Product();
        p1.setName("Laptop");
        
        Users user = new Users();
        user.setId(101);
        user.setName("shivam");
        user.setProduct(p1);
        
        Users user1 = new Users();
        user1.setId(102);
        user1.setName("Komal");
        user1.setProduct(p1);
        
        Users user2 = new Users();
        user2.setId(103);
        user2.setName("prerana");
        user2.setProduct(p1);
        
        List<Users> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        
        p1.setUsers(list);
        
        
        session.persist(p1);
        
        tx.commit();
        session.close();



   }
}
