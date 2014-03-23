package com.cardiodx.db.waban.table;

// Generated Jul 14, 2011 12:30:46 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class DataImportColDictTab.
 * @see com.cardiodx.db.waban.table.DataImportColDictTab
 * @author Hibernate Tools
 */
public class DataImportColDictTabHome {

	private static final Log log = LogFactory
			.getLog(DataImportColDictTabHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(DataImportColDictTab transientInstance) {
		log.debug("persisting DataImportColDictTab instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DataImportColDictTab instance) {
		log.debug("attaching dirty DataImportColDictTab instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DataImportColDictTab instance) {
		log.debug("attaching clean DataImportColDictTab instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DataImportColDictTab persistentInstance) {
		log.debug("deleting DataImportColDictTab instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DataImportColDictTab merge(DataImportColDictTab detachedInstance) {
		log.debug("merging DataImportColDictTab instance");
		try {
			DataImportColDictTab result = (DataImportColDictTab) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DataImportColDictTab findById(
			com.cardiodx.db.waban.table.DataImportColDictTabId id) {
		log.debug("getting DataImportColDictTab instance with id: " + id);
		try {
			DataImportColDictTab instance = (DataImportColDictTab) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.DataImportColDictTab",
							id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<DataImportColDictTab> findByExample(
			DataImportColDictTab instance) {
		log.debug("finding DataImportColDictTab instance by example");
		try {
			List<DataImportColDictTab> results = (List<DataImportColDictTab>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.DataImportColDictTab")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
