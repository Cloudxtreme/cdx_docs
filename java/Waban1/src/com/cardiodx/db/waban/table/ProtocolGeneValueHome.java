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
 * Home object for domain model class ProtocolGeneValue.
 * @see com.cardiodx.db.waban.table.ProtocolGeneValue
 * @author Hibernate Tools
 */
public class ProtocolGeneValueHome {

	private static final Log log = LogFactory
			.getLog(ProtocolGeneValueHome.class);

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

	public void persist(ProtocolGeneValue transientInstance) {
		log.debug("persisting ProtocolGeneValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProtocolGeneValue instance) {
		log.debug("attaching dirty ProtocolGeneValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProtocolGeneValue instance) {
		log.debug("attaching clean ProtocolGeneValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProtocolGeneValue persistentInstance) {
		log.debug("deleting ProtocolGeneValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProtocolGeneValue merge(ProtocolGeneValue detachedInstance) {
		log.debug("merging ProtocolGeneValue instance");
		try {
			ProtocolGeneValue result = (ProtocolGeneValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProtocolGeneValue findById(
			com.cardiodx.db.waban.table.ProtocolGeneValueId id) {
		log.debug("getting ProtocolGeneValue instance with id: " + id);
		try {
			ProtocolGeneValue instance = (ProtocolGeneValue) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ProtocolGeneValue", id);
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

	public List<ProtocolGeneValue> findByExample(ProtocolGeneValue instance) {
		log.debug("finding ProtocolGeneValue instance by example");
		try {
			List<ProtocolGeneValue> results = (List<ProtocolGeneValue>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProtocolGeneValue")
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
