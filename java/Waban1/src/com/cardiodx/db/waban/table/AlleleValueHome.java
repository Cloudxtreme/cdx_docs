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
 * Home object for domain model class AlleleValue.
 * @see com.cardiodx.db.waban.table.AlleleValue
 * @author Hibernate Tools
 */
public class AlleleValueHome {

	private static final Log log = LogFactory.getLog(AlleleValueHome.class);

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

	public void persist(AlleleValue transientInstance) {
		log.debug("persisting AlleleValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AlleleValue instance) {
		log.debug("attaching dirty AlleleValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AlleleValue instance) {
		log.debug("attaching clean AlleleValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AlleleValue persistentInstance) {
		log.debug("deleting AlleleValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AlleleValue merge(AlleleValue detachedInstance) {
		log.debug("merging AlleleValue instance");
		try {
			AlleleValue result = (AlleleValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AlleleValue findById(com.cardiodx.db.waban.table.AlleleValueId id) {
		log.debug("getting AlleleValue instance with id: " + id);
		try {
			AlleleValue instance = (AlleleValue) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.AlleleValue", id);
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

	public List<AlleleValue> findByExample(AlleleValue instance) {
		log.debug("finding AlleleValue instance by example");
		try {
			List<AlleleValue> results = (List<AlleleValue>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.AlleleValue")
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
