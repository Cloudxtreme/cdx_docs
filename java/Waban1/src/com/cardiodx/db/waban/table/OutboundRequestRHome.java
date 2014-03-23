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
 * Home object for domain model class OutboundRequestR.
 * @see com.cardiodx.db.waban.table.OutboundRequestR
 * @author Hibernate Tools
 */
public class OutboundRequestRHome {

	private static final Log log = LogFactory
			.getLog(OutboundRequestRHome.class);

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

	public void persist(OutboundRequestR transientInstance) {
		log.debug("persisting OutboundRequestR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OutboundRequestR instance) {
		log.debug("attaching dirty OutboundRequestR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OutboundRequestR instance) {
		log.debug("attaching clean OutboundRequestR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OutboundRequestR persistentInstance) {
		log.debug("deleting OutboundRequestR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OutboundRequestR merge(OutboundRequestR detachedInstance) {
		log.debug("merging OutboundRequestR instance");
		try {
			OutboundRequestR result = (OutboundRequestR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OutboundRequestR findById(
			com.cardiodx.db.waban.table.OutboundRequestRId id) {
		log.debug("getting OutboundRequestR instance with id: " + id);
		try {
			OutboundRequestR instance = (OutboundRequestR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OutboundRequestR", id);
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

	public List<OutboundRequestR> findByExample(OutboundRequestR instance) {
		log.debug("finding OutboundRequestR instance by example");
		try {
			List<OutboundRequestR> results = (List<OutboundRequestR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.OutboundRequestR")
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
