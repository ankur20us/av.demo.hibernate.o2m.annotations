package av.demo.hibernate.o2m.annotations.service;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import av.demo.hibernate.o2m.annotations.modal.Customer;
import av.demo.hibernate.o2m.annotations.modal.Vendor;

public class Example {

	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;
		
		try {
			
			Configuration 	cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			System.out.println("hello");	

			factory = cfg.configure().buildSessionFactory();
			session = factory.openSession();
			
			/***
			 * AV:
			 * 		Inserting the data
			 */
			Transaction tx = null;
			
			tx = session.beginTransaction();
				Vendor v1 = new Vendor();
				Set<Customer> customers = new HashSet<Customer>();
					Customer c1 = new Customer(101, "A101");
					Customer c2 = new Customer(102, "A102");
					customers.add(c1);
					customers.add(c2);
				v1.setVendorId(10101);
				v1.setVendorName("Name10101");
				v1.setCustomers(customers);
			session.save(v1);
			tx.commit();
			
			/***
			 * AV:
			 * 		Getting the data
			 */
			v1 = session.get(Vendor.class, 10101);
			System.out.println(v1);
			
			/***
			 * AV:
			 * 		Deleting the data
			 */
			tx = session.beginTransaction();
			session.delete(v1);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null){
				session.close();
			}
			if(factory != null){
				factory.close();				
			}
		}
	}
	
}
