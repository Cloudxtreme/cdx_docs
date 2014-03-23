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
 * Home object for domain model class OrganizationVariableFld.
 * @see com.cardiodx.db.waban.table.OrganizationVariableFld
 * @author Hibernate Tools
 */
public class OrganizationVariableFldHome {

	private static final Log log = LogFactory
			.getLog(OrganizationVariableFldHome.class);

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

	public void persist(OrganizationVariableFld transientInstance) {
		log.debug("persisting OrganizationVariableFld instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationVariableFld instance) {
		log.debug("attaching dirty OrganizationVariableFld instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationVariableFld instance) {
		log.debug("attaching clean OrganizationVariableFld instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrganizationVariableFld persistentInstance) {
		log.debug("deleting OrganizationVariableFld instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationVariableFld merge(
			OrganizationVariableFld detachedInstance) {
		log.debug("merging OrganizationVariableFld instance");
		try {
			OrganizationVariableFld result = (OrganizationVariableFld) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrganizationVariableFld findById(java.math.BigDecimal id) {
		log.debug("getting OrganizationVariableFld instance with id: " + id);
		try {
			OrganizationVariableFld instance = (OrganizationVariableFld) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.OrganizationVariableFld",
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

	public List<OrganizationVariableFld> findByExample(
			OrganizationVariableFld instance) {
		log.debug("finding OrganizationVariableFld instance by example");
		try {
			List<OrganizationVariableFld> results = (List<OrganizationVariableFld>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.OrganizationVariableFld")
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
