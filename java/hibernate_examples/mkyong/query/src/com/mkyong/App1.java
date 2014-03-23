package com.mkyong;
 
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
 
import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;
 
public class App1 {
	public static void main(String[] args) {
 
        System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
 
		Stock stock = new Stock("7052", "ORCL");
    	session.save(stock);

		StockDailyRecord d1 = new StockDailyRecord(stock, new Float("1.1"), new Float("1.2"), new Float("10.0"), 1000000L, new Date());
        session.save(d1);

		StockDailyRecord d2 = new StockDailyRecord(stock, new Float("2.1"), new Float("2.2"), new Float("20.0"), 2000000L, new Date());
        session.save(d2);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
