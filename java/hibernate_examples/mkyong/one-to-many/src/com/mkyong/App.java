package com.mkyong;
 
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
 
import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;
 
public class App {
	public static void main(String[] args) {
 
        System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		session.beginTransaction();
 
		Stock stock = new Stock("1234", "MSFT");

		Set<StockDailyRecord> records = new HashSet<StockDailyRecord>();
		records.add(new StockDailyRecord(stock, new Float("1.1"), new Float("1.2"), new Float("10.0"), 1000000L, new Date()));
		records.add(new StockDailyRecord(stock, new Float("2.1"), new Float("2.2"), new Float("20.0"), 2000000L, new Date()));

		stock.setStockDailyRecords(records);
    	session.save(stock);

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
