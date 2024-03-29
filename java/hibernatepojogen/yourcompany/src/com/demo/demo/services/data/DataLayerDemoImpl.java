package com.demo.demo.services.data;

import com.demo.demo.factories.demo.*;
import com.demo.demo.model.obj.demo.Customer;
import com.demo.demo.model.obj.demo.Line;
import com.demo.demo.model.obj.demo.Order;
import com.demo.demo.model.obj.demo.Stock;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import com.demo.persistence.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.hibernate.SessionFactory;
import org.hibernate.proxy.HibernateProxy;
/** 
 * Data layer.
 * @author autogenerated
 */
@org.springframework.stereotype.Component
public class DataLayerDemoImpl implements DataLayerDemo {
	 /** Sessionfactory in use. Filled in by Spring. */ 
    private SessionFactory sessionFactory = null;
	/** Singleton reference to this class. */
	private static DataLayerDemo instance;
	/** map lock. */
	private static Object daoMapLock = new Object();

	/** Internal handle. */
	@SuppressWarnings("unchecked")
	private static Map<Class<?>, GenericDAO<?, ?>> daoMap = null; 
	
		/** Inner handle. */
	private static ApplicationContext context;

	/** Handle to get back ourselves and perform correct injection. 
	 * @param context filled by spring
	 */
	@Autowired
	public void setApplicationContext(ApplicationContext context) {
		DataLayerDemoImpl.context = context;
	}
	
	
		
 	/**
     * Set session factory.
     * @param sessionFactory sessionfactory to use. 
     */
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    /** 
	* Returns a DAO instance of the given type.
	* @param <T> Type
	* @param persistentObject to get
	* @return GenericDAO<T, ?> object
     */
    @SuppressWarnings("unchecked")
    private <T> GenericDAO<T, ?> getDAO(final T persistentObject) {
		T persistent = persistentObject;

		synchronized(daoMapLock){
    		if (daoMap == null) {
    			daoMap = new ConcurrentHashMap<Class<?>, GenericDAO<?, ?>>(); 
	 	   		daoMap.put(Customer.class, HibernateDemoDaoFactory.getCustomerDao());
	 	   		daoMap.put(Line.class, HibernateDemoDaoFactory.getLineDao());
	 	   		daoMap.put(Order.class, HibernateDemoDaoFactory.getOrderDao());
	 	   		daoMap.put(Stock.class, HibernateDemoDaoFactory.getStockDao());
    		}
		 }
		if (persistentObject instanceof HibernateProxy) {
			persistent = (T)((HibernateProxy)persistentObject).getHibernateLazyInitializer().getImplementation();
		} 
		
		GenericDAO<T, ?> result = (GenericDAO<T, ?>) daoMap.get(persistent.getClass());
		if (result == null) {
			throw new IllegalAccessError("The given object is of an incorrect type. ");
		}
		return result;
    }

    /**
     * Deletes the given object from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to delete
     */
    public <T> void delete(T persistentObject) {
    	    	getDAO(persistentObject).delete(persistentObject);
    }
    /**
     * Refresh the object $class.className from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to reload
     */
    public <T> void refresh(T persistentObject) {
	    	getDAO(persistentObject).refresh(persistentObject);
    }

    /**
     * Saves the given object to disk.
     * @param persistentObject Object to save
	 * @param <T> A DataLayerObject-derived type
     * @return Identifier of saved object 
     */
    public <T> Serializable save(T persistentObject) {
        return getDAO(persistentObject).save(persistentObject);
    }
    /**
     * Saves or updates the given $class.className object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to save 
     */
    public <T> void saveOrUpdate(T persistentObject) {
        getDAO(persistentObject).saveOrUpdate(persistentObject);
    }
    /**
     * Updates the given object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to update 
     */
    public <T> void update(T persistentObject) {
        getDAO(persistentObject).update(persistentObject);
    }


    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Customer obj) directly
     * @param id Identifier to delete
     */
    public void deleteCustomer(final Serializable id)  {
        HibernateDemoDaoFactory.getCustomerDao().delete(loadCustomer(id));
    }
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Customer object
     */
    public Customer loadCustomer(final Serializable id) {
        return HibernateDemoDaoFactory.getCustomerDao().load(id);
    }
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     public Customer getCustomer(final Serializable id) {
        return HibernateDemoDaoFactory.getCustomerDao().get(id);
    }  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Line obj) directly
     * @param id Identifier to delete
     */
    public void deleteLine(final Serializable id)  {
        HibernateDemoDaoFactory.getLineDao().delete(loadLine(id));
    }
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Line object
     */
    public Line loadLine(final Serializable id) {
        return HibernateDemoDaoFactory.getLineDao().load(id);
    }
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     public Line getLine(final Serializable id) {
        return HibernateDemoDaoFactory.getLineDao().get(id);
    }  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Order obj) directly
     * @param id Identifier to delete
     */
    public void deleteOrder(final Serializable id)  {
        HibernateDemoDaoFactory.getOrderDao().delete(loadOrder(id));
    }
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Order object
     */
    public Order loadOrder(final Serializable id) {
        return HibernateDemoDaoFactory.getOrderDao().load(id);
    }
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     public Order getOrder(final Serializable id) {
        return HibernateDemoDaoFactory.getOrderDao().get(id);
    }  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Stock obj) directly
     * @param id Identifier to delete
     */
    public void deleteStock(final Serializable id)  {
        HibernateDemoDaoFactory.getStockDao().delete(loadStock(id));
    }
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Stock object
     */
    public Stock loadStock(final Serializable id) {
        return HibernateDemoDaoFactory.getStockDao().load(id);
    }
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     public Stock getStock(final Serializable id) {
        return HibernateDemoDaoFactory.getStockDao().get(id);
    }  
    /** Returns a singleton instance of this class.
     * @return an singleton instance
     */
    public static synchronized DataLayerDemo getInstance() {
        
        if (instance == null) {
     		instance = (DataLayerDemo) context.getBean("dataLayerDemoImpl");
        }
        
        return instance; 
    }
    /** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     public Query createQuery(final String query) {
        return sessionFactory.getCurrentSession().createQuery(query);
    }
    /** Returns a criteria handle.
     * @param criteria Criteria to use
     * @return A criteria instance
     */
     public Criteria createCriteria(final String criteria) {
        return sessionFactory.getCurrentSession().createCriteria(criteria);
    }
    /** Returns a Query handle based on your package-level named query.
     * @param query Query to use
     * @return A query instance
     */
     public Query getNamedQuery(final String query) {
        return sessionFactory.getCurrentSession().getNamedQuery(query);
    }
    /** Create a new Criteria instance, for the given entity class, or a superclass of an entity class.
	* @param persistentObject a class, which is persistent, or has persistent subclasses 
	* @return Criteria instance
	*/
	@SuppressWarnings("unchecked")
	public Criteria createCriteria(Class persistentObject) {
        return sessionFactory.getCurrentSession().createCriteria(persistentObject);
    }
    /** Flushes the currently open session.
	*/
	public void flushSession() {
        sessionFactory.getCurrentSession().flush();
    }
    /** Clears the currently open session.
	*/
	public void clearSession() {
        sessionFactory.getCurrentSession().clear();
    }
    /** Flushes and clears the currently open session.
	*/
	public void flushAndClearSession() {
		flushSession();
		clearSession();
    }
	/** Call currentSession.replicate.
	 * @param obj to replicate
	 * @param replicationMode mode
	 */ 
	public void replicate(Object obj, ReplicationMode replicationMode) {
		sessionFactory.getCurrentSession().replicate(obj, replicationMode);
	}
	/** Hibernate Merge. 
	 * @param obj to merge
	 * @return obj merged.
	 */
	public Object merge(Object obj) {
		return sessionFactory.getCurrentSession().merge(obj);
	}
	/** Returns the current session.
	 * @return the currently active session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	/** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     public SQLQuery createSQLQuery(final String query) {
        return sessionFactory.getCurrentSession().createSQLQuery(query);
    }
    /** Remove this instance from the session cache. 
	 * Changes to the instance will not be synchronized with the database
	 * @param obj object to evict
	 */
	public void evict(Object obj) {
        sessionFactory.getCurrentSession().evict(obj);
    }}

