package com.demo.demo.services.data;

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
/** 
 * Data layer.
 * @author autogenerated
 */
public interface DataLayerDemo {

    /**
     * Deletes the given object from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to delete
     */
    <T> void delete(T persistentObject);
    /**
     * Refresh the object $class.className from disk.
     * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to reload
     */
    <T> void refresh(T persistentObject);

    /**
     * Saves the given object to disk.
     * @param persistentObject Object to save
	 * @param <T> A DataLayerObject-derived type
     * @return Identifier of saved object 
     */
    <T> Serializable save(T persistentObject);
    /**
     * Saves or updates the given $class.className object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to save 
     */
    <T> void saveOrUpdate(T persistentObject);
    /**
     * Updates the given object to disk.
	 * @param <T> A DataLayerObject-derived type
     * @param persistentObject Object to update 
     */
    <T> void update(T persistentObject);


    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Customer obj) directly
     * @param id Identifier to delete
     */
    void deleteCustomer(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Customer object
     */
    Customer loadCustomer(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Customer getCustomer(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Line obj) directly
     * @param id Identifier to delete
     */
    void deleteLine(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Line object
     */
    Line loadLine(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Line getLine(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Order obj) directly
     * @param id Identifier to delete
     */
    void deleteOrder(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Order object
     */
    Order loadOrder(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Order getOrder(final Serializable id);  

    /** Deletes an object of a given Id. 
     * Will load the object internally so consider using delete (Stock obj) directly
     * @param id Identifier to delete
     */
    void deleteStock(final Serializable id);
	
    /**
     * Loads the given Object.
     * @param id Identifier to load
     * @return a Stock object
     */
    Stock loadStock(final Serializable id);
    /**
     * Loads the given Object.
     * @param id Id to load
     * @return An object of type T
     */
     Stock getStock(final Serializable id);  
    /** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     Query createQuery(final String query);
    /** Returns a criteria handle.
     * @param criteria Criteria to use
     * @return A criteria instance
     */
     Criteria createCriteria(final String criteria);
    /** Returns a Query handle based on your package-level named query.
     * @param query Query to use
     * @return A query instance
     */
     Query getNamedQuery(final String query);
    /** Create a new Criteria instance, for the given entity class, or a superclass of an entity class.
	* @param persistentObject a class, which is persistent, or has persistent subclasses 
	* @return Criteria instance
	*/
	@SuppressWarnings("unchecked")
	Criteria createCriteria(Class persistentObject);
    /** Flushes the currently open session.
	*/
	void flushSession();
    /** Clears the currently open session.
	*/
	void clearSession();
    /** Flushes and clears the currently open session.
	*/
	void flushAndClearSession();
	/** Call currentSession.replicate.
	 * @param obj to replicate
	 * @param replicationMode mode
	 */ 
	void replicate(Object obj, ReplicationMode replicationMode);
	/** Hibernate Merge. 
	 * @param obj to merge
	 * @return obj merged.
	 */
	Object merge(Object obj);
	/** Returns the current session.
	 * @return the currently active session
	 */
	Session getCurrentSession();
	/** Returns a query handle.
     * @param query Query to use
     * @return A query instance
     */
     SQLQuery createSQLQuery(final String query);
    /** Remove this instance from the session cache. 
	 * Changes to the instance will not be synchronized with the database
	 * @param obj object to evict
	 */
	void evict(Object obj);}

