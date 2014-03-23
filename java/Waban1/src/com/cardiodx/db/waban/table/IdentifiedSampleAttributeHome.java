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
 * Home object for domain model class IdentifiedSampleAttribute.
 * @see com.cardiodx.db.waban.table.IdentifiedSampleAttribute
 * @author Hibernate Tools
 */
public class IdentifiedSampleAttributeHome {

	private static final Log log = LogFactory
			.getLog(IdentifiedSampleAttributeHome.class);

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

	public void persist(IdentifiedSampleAttribute transientInstance) {
		log.debug("persisting IdentifiedSampleAttribute instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(IdentifiedSampleAttribute instance) {
		log.debug("attaching dirty IdentifiedSampleAttribute instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(IdentifiedSampleAttribute instance) {
		log.debug("attaching clean IdentifiedSampleAttribute instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(IdentifiedSampleAttribute persistentInstance) {
		log.debug("deleting IdentifiedSampleAttribute instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IdentifiedSampleAttribute merge(
			IdentifiedSampleAttribute detachedInstance) {
		log.debug("merging IdentifiedSampleAttribute instance");
		try {
			IdentifiedSampleAttribute result = (IdentifiedSampleAttribute) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public IdentifiedSampleAttribute findById(java.math.BigDecimal id) {
		log.debug("getting IdentifiedSampleAttribute instance with id: " + id);
		try {
			IdentifiedSampleAttribute instance = (IdentifiedSampleAttribute) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.IdentifiedSampleAttribute",
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

	public List<IdentifiedSampleAttribute> findByExample(
			IdentifiedSampleAttribute instance) {
		log.debug("finding IdentifiedSampleAttribute instance by example");
		try {
			List<IdentifiedSampleAttribute> results = (List<IdentifiedSampleAttribute>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.IdentifiedSampleAttribute")
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
