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
 * Home object for domain model class EventHandlerR.
 * @see com.cardiodx.db.waban.table.EventHandlerR
 * @author Hibernate Tools
 */
public class EventHandlerRHome {

	private static final Log log = LogFactory.getLog(EventHandlerRHome.class);

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

	public void persist(EventHandlerR transientInstance) {
		log.debug("persisting EventHandlerR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(EventHandlerR instance) {
		log.debug("attaching dirty EventHandlerR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(EventHandlerR instance) {
		log.debug("attaching clean EventHandlerR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(EventHandlerR persistentInstance) {
		log.debug("deleting EventHandlerR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public EventHandlerR merge(EventHandlerR detachedInstance) {
		log.debug("merging EventHandlerR instance");
		try {
			EventHandlerR result = (EventHandlerR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EventHandlerR findById(com.cardiodx.db.waban.table.EventHandlerRId id) {
		log.debug("getting EventHandlerR instance with id: " + id);
		try {
			EventHandlerR instance = (EventHandlerR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.EventHandlerR", id);
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

	public List<EventHandlerR> findByExample(EventHandlerR instance) {
		log.debug("finding EventHandlerR instance by example");
		try {
			List<EventHandlerR> results = (List<EventHandlerR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.EventHandlerR")
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
