import java.util.List;
import java.util.Iterator;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  


public class CustomerDAO {  

  	private Session session = null;  

 	public void createSession(){  
  		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");  
  		SessionFactory sf = cfg.buildSessionFactory();  
  		this.session = sf.getCurrentSession();  
 	}  
  
	public Customer create(Customer newCustomer) {  
     	Transaction transaction = session.beginTransaction();  
        session.save(newCustomer);  
        transaction.commit();  
        return newCustomer;  
    }  

	public void list() {
        Transaction transaction = session.beginTransaction();
        List customers = session.createQuery("from TAB_CUSTOMER").list();
        for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
            Customer customer = (Customer) iterator.next();
            System.out.println(customer.getCustomerId());
        }
        transaction.commit();
	}
  
	public static void main(String[] args){  
     	Customer customer = new Customer();  
     	customer.setCustomerName("Hibernate Example Customer");  
  
    	System.out.println("Customer id before creation:" +  customer.getCustomerId());  
     	CustomerDAO customerDAO = new CustomerDAO();  
     	customerDAO.createSession();  
//		customerDAO.list();
     	Customer persistedCustomer = customerDAO.create(customer);  
     	System.out.println("Customer id after creation:" +  persistedCustomer.getCustomerId());  

		
    }  
}  
