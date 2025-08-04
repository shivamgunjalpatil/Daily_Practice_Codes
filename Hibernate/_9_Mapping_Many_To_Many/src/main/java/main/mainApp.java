package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Roles;
import entity.User;


public class mainApp {

	public static void main(String[] args) {
		   Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Roles.class);
		   
		   SessionFactory sf = cfg.buildSessionFactory();
		   
		   Session session = sf.openSession();
		   
		   Transaction tx = session.beginTransaction();
		   
		   Roles admin = new Roles();
		   admin.setRollId(1001);
		   admin.setName("ADMIN");
		   
		   
		   Roles editor = new Roles();
		   editor.setRollId(1002);
		   editor.setName("Editor");
		   
		   User u1 = new User();
		   u1.setUsername("shivam gunjal");
		  
		   List<Roles>list = new ArrayList<>();
		   list.add(admin);
		   list.add(editor);
		   
		  
		   u1.setRoles(list);
		   
		   
		   session.persist(admin);
		   session.persist(editor);
		   session.persist(u1);
		  
		   
		   tx.commit();
		   session.close();
		   
		   
		   
		   
		   
		   

	}

}
