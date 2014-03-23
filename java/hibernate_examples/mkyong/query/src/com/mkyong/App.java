package com.mkyong;
 
import java.util.List;
import java.util.Iterator;
 
import org.hibernate.Session;
import org.hibernate.Query;
 
import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;
 
public class App {
	public static void main(String[] args) {
 
        System.out.println("Hibernate one to many (XML Mapping)");
		Session session = HibernateUtil.getSessionFactory().openSession();
 
		// HQL
		Query query = session.createQuery("from Stock where stockCode = :code ");
		query.setParameter("code", "1234");
		List result = query.list();

		System.out.println(result.size());

		for(Iterator it = result.iterator();it.hasNext();){
			 //System.out.println(it.next().getClass().getName());
  			Stock stock = (Stock) it.next();
  			System.out.println(stock.getStockCode() + " : " + stock.getStockName());
  		}

		// native SQL statement w/ .addEntity
		query = session.createSQLQuery("select * from stock s where s.stock_code = :stockCode")
			.addEntity(Stock.class)
			.setParameter("stockCode", "1234");
		result = query.list();

        for(Iterator it = result.iterator();it.hasNext();){
            Stock stock = (Stock) it.next();
            System.out.println(stock.getStockCode() + " : " + stock.getStockName());
        }

		// native SQL statement w/o .addEntity
		String sql = "select * "
            + "from stock s, category c, stock_category sc "
            + "where s.stock_id = sc.stock_id "
            + "and c.category_id = sc.category_id "
            + "and c.name = :name";

        query = session.createSQLQuery(sql)
            .setParameter("name", "CONSUMER");
        result = query.list();

        for(Iterator it = result.iterator();it.hasNext();){
            Object[] row = (Object[]) it.next();
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
	}
}

