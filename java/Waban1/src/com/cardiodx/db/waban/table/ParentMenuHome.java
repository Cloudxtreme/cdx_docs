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
 * Home object for domain model class ParentMenu.
 * @see com.cardiodx.db.waban.table.ParentMenu
 * @author Hibernate Tools
 */
public class ParentMenuHome {

	private static final Log log = LogFactory.getLog(ParentMenuHome.class);

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

	public void persist(ParentMenu transientInstance) {
		log.debug("persisting ParentMenu instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ParentMenu instance) {
		log.debug("attaching dirty ParentMenu instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ParentMenu instance) {
		log.debug("attaching clean ParentMenu instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ParentMenu persistentInstance) {
		log.debug("deleting ParentMenu instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ParentMenu merge(ParentMenu detachedInstance) {
		log.debug("merging ParentMenu instance");
		try {
			ParentMenu result = (ParentMenu) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ParentMenu findById(java.math.BigDecimal id) {
		log.debug("getting ParentMenu instance with id: " + id);
		try {
			ParentMenu instance = (ParentMenu) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ParentMenu", id);
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

	public List<ParentMenu> findByExample(ParentMenu instance) {
		log.debug("finding ParentMenu instance by example");
		try {
			List<ParentMenu> results = (List<ParentMenu>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ParentMenu")
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
