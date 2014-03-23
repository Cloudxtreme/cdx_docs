package com.mkyong;
 
import java.util.Date;
 
import org.hibernate.Session;
 
import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;
 
public class App3 {
	public static void main(String[] args) {
 
        System.out.println("Hibernate one to many (XML Mapping)");
	Session session = HibernateUtil.getSessionFactory().openSession();
 
	session.beginTransaction();
 
	Stock stock = new Stock();
        //stock.setStockId(9);
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
 
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
		//stockDailyRecords.setRecordId(2);
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setXdate(new Date());
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.save(stockDailyRecords);

 
        StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
        //stockDailyRecords2.setRecordId(3);
        stockDailyRecords2.setPriceOpen(new Float("1.2"));
        stockDailyRecords2.setPriceClose(new Float("1.1"));
        stockDailyRecords2.setPriceChange(new Float("10.0"));
        stockDailyRecords2.setVolume(3000000L);
        stockDailyRecords2.setXdate(new Date());
        stockDailyRecords2.setStock(stock);         
        stock.getStockDailyRecords().add(stockDailyRecords2);

        session.save(stockDailyRecords2);
 
	session.getTransaction().commit();
	System.out.println("Done");
	}
}
