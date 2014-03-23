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
 * Home object for domain model class OrganizationAttribute.
 * @see com.cardiodx.db.waban.table.OrganizationAttribute
 * @author Hibernate Tools
 */
public class OrganizationAttributeHome {

	private static final Log log = LogFactory
			.getLog(OrganizationAttributeHome.class);

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

	public void persist(OrganizationAttribute transientInstance) {
		log.debug("persisting OrganizationAttribute instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OrganizationAttribute instance) {
		log.debug("attaching dirty OrganizationAttribute instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrganizationAttribute instance) {
		log.debug("attaching clean OrganizationAttribute instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OrganizationAttribute persistentInstance) {
		log.debug("deleting OrganizationAttribute instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrganizationAttribute merge(OrganizationAttribute detachedInstance) {
		log.debug("merging OrganizationAttribute instance");
		try {
			OrganizationAttribute result = (OrganizationAttribute) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OrganizationAttribute findById(java.math.BigDecimal id) {
		log.debug("getting OrganizationAttribute instance with id: " + id);
		try {
			OrganizationAttribute instance = (OrganizationAttribute) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.OrganizationAttribute",
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

	public List<OrganizationAttribute> findByExample(
			OrganizationAttribute instance) {
		log.debug("finding OrganizationAttribute instance by example");
		try {
			List<OrganizationAttribute> results = (List<OrganizationAttribute>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.OrganizationAttribute")
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
