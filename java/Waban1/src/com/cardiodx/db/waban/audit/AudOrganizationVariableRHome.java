package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudOrganizationVariableR.
 * @see com.cardiodx.db.waban.audit.AudOrganizationVariableR
 * @author Hibernate Tools
 */
public class AudOrganizationVariableRHome {

	private static final Log log = LogFactory
			.getLog(AudOrganizationVariableRHome.class);

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

	public void persist(AudOrganizationVariableR transientInstance) {
		log.debug("persisting AudOrganizationVariableR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudOrganizationVariableR instance) {
		log.debug("attaching dirty AudOrganizationVariableR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudOrganizationVariableR instance) {
		log.debug("attaching clean AudOrganizationVariableR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudOrganizationVariableR persistentInstance) {
		log.debug("deleting AudOrganizationVariableR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudOrganizationVariableR merge(
			AudOrganizationVariableR detachedInstance) {
		log.debug("merging AudOrganizationVariableR instance");
		try {
			AudOrganizationVariableR result = (AudOrganizationVariableR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudOrganizationVariableR findById(
			com.cardiodx.db.waban.audit.AudOrganizationVariableRId id) {
		log.debug("getting AudOrganizationVariableR instance with id: " + id);
		try {
			AudOrganizationVariableR instance = (AudOrganizationVariableR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudOrganizationVariableR",
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

	public List<AudOrganizationVariableR> findByExample(
			AudOrganizationVariableR instance) {
		log.debug("finding AudOrganizationVariableR instance by example");
		try {
			List<AudOrganizationVariableR> results = (List<AudOrganizationVariableR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudOrganizationVariableR")
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
