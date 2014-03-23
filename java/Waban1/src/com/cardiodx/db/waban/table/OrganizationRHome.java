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
 * Home object for domain model class OrganizationR.
 * @see com.cardiodx.db.waban.table.OrganizationR
 * @author Hibernate Tools
 */
public class OrganizationRHome {

	private static final Log log = LogFactory.getLog(OrganizationRHome.class);

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

	public void persist(OrganizationR transientInstance) {
		log.debug("persisting OrganizationR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationR instance) {
		log.debug("attaching dirty OrganizationR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationR instance) {
		log.debug("attaching clean OrganizationR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrganizationR persistentInstance) {
		log.debug("deleting OrganizationR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationR merge(OrganizationR detachedInstance) {
		log.debug("merging OrganizationR instance");
		try {
			OrganizationR result = (OrganizationR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrganizationR findById(com.cardiodx.db.waban.table.OrganizationRId id) {
		log.debug("getting OrganizationR instance with id: " + id);
		try {
			OrganizationR instance = (OrganizationR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OrganizationR", id);
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

	public List<OrganizationR> findByExample(OrganizationR instance) {
		log.debug("finding OrganizationR instance by example");
		try {
			List<OrganizationR> results = (List<OrganizationR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.OrganizationR")
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
