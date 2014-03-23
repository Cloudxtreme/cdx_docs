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
 * Home object for domain model class RoiAttribute.
 * @see com.cardiodx.db.waban.table.RoiAttribute
 * @author Hibernate Tools
 */
public class RoiAttributeHome {

	private static final Log log = LogFactory.getLog(RoiAttributeHome.class);

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

	public void persist(RoiAttribute transientInstance) {
		log.debug("persisting RoiAttribute instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(RoiAttribute instance) {
		log.debug("attaching dirty RoiAttribute instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RoiAttribute instance) {
		log.debug("attaching clean RoiAttribute instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(RoiAttribute persistentInstance) {
		log.debug("deleting RoiAttribute instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RoiAttribute merge(RoiAttribute detachedInstance) {
		log.debug("merging RoiAttribute instance");
		try {
			RoiAttribute result = (RoiAttribute) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoiAttribute findById(java.math.BigDecimal id) {
		log.debug("getting RoiAttribute instance with id: " + id);
		try {
			RoiAttribute instance = (RoiAttribute) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.RoiAttribute", id);
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

	public List<RoiAttribute> findByExample(RoiAttribute instance) {
		log.debug("finding RoiAttribute instance by example");
		try {
			List<RoiAttribute> results = (List<RoiAttribute>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.RoiAttribute")
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
