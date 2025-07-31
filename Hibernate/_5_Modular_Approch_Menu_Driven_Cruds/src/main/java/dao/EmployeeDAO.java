package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entity.Employee;


public class EmployeeDAO {
	
	private static SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
	public void save(Employee emp)
	{
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.persist(emp);
		tx.commit();
		session.close();
	}
	public void remove(Employee emp)
	{
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.remove(emp);
		tx.commit();
		session.close();
		
	}
	public void update(Employee emp)
	{
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		session.merge(emp);
		tx.commit();
		session.close();
	}
	public List<Employee> getAll()
	{
		Session session = sf.openSession();
		
		Query<Employee> q = session.createQuery("from Employee",Employee.class);
		List<Employee> list = q.list();
		
		return list;
		
	}
	

}
