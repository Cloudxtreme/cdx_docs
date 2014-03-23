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
 * Home object for domain model class UppercaseField.
 * @see com.cardiodx.db.waban.table.UppercaseField
 * @author Hibernate Tools
 */
public class UppercaseFieldHome {

	private static final Log log = LogFactory.getLog(UppercaseFieldHome.class);

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

	public void persist(UppercaseField transientInstance) {
		log.debug("persisting UppercaseField instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(UppercaseField instance) {
		log.debug("attaching dirty UppercaseField instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UppercaseField instance) {
		log.debug("attaching clean UppercaseField instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(UppercaseField persistentInstance) {
		log.debug("deleting UppercaseField instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UppercaseField merge(UppercaseField detachedInstance) {
		log.debug("merging UppercaseField instance");
		try {
			UppercaseField result = (UppercaseField) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UppercaseField findById(
			com.cardiodx.db.waban.table.UppercaseFieldId id) {
		log.debug("getting UppercaseField instance with id: " + id);
		try {
			UppercaseField instance = (UppercaseField) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.UppercaseField", id);
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

	public List<UppercaseField> findByExample(UppercaseField instance) {
		log.debug("finding UppercaseField instance by example");
		try {
			List<UppercaseField> results = (List<UppercaseField>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.UppercaseField")
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
