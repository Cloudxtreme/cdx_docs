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
 * Home object for domain model class ProtocolAlleleValue.
 * @see com.cardiodx.db.waban.table.ProtocolAlleleValue
 * @author Hibernate Tools
 */
public class ProtocolAlleleValueHome {

	private static final Log log = LogFactory
			.getLog(ProtocolAlleleValueHome.class);

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

	public void persist(ProtocolAlleleValue transientInstance) {
		log.debug("persisting ProtocolAlleleValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProtocolAlleleValue instance) {
		log.debug("attaching dirty ProtocolAlleleValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProtocolAlleleValue instance) {
		log.debug("attaching clean ProtocolAlleleValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProtocolAlleleValue persistentInstance) {
		log.debug("deleting ProtocolAlleleValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProtocolAlleleValue merge(ProtocolAlleleValue detachedInstance) {
		log.debug("merging ProtocolAlleleValue instance");
		try {
			ProtocolAlleleValue result = (ProtocolAlleleValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProtocolAlleleValue findById(
			com.cardiodx.db.waban.table.ProtocolAlleleValueId id) {
		log.debug("getting ProtocolAlleleValue instance with id: " + id);
		try {
			ProtocolAlleleValue instance = (ProtocolAlleleValue) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ProtocolAlleleValue",
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

	public List<ProtocolAlleleValue> findByExample(ProtocolAlleleValue instance) {
		log.debug("finding ProtocolAlleleValue instance by example");
		try {
			List<ProtocolAlleleValue> results = (List<ProtocolAlleleValue>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProtocolAlleleValue")
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
