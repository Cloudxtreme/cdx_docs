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
 * Home object for domain model class AudStepTemplateParameter.
 * @see com.cardiodx.db.waban.audit.AudStepTemplateParameter
 * @author Hibernate Tools
 */
public class AudStepTemplateParameterHome {

	private static final Log log = LogFactory
			.getLog(AudStepTemplateParameterHome.class);

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

	public void persist(AudStepTemplateParameter transientInstance) {
		log.debug("persisting AudStepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudStepTemplateParameter instance) {
		log.debug("attaching dirty AudStepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudStepTemplateParameter instance) {
		log.debug("attaching clean AudStepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudStepTemplateParameter persistentInstance) {
		log.debug("deleting AudStepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudStepTemplateParameter merge(
			AudStepTemplateParameter detachedInstance) {
		log.debug("merging AudStepTemplateParameter instance");
		try {
			AudStepTemplateParameter result = (AudStepTemplateParameter) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudStepTemplateParameter findById(java.math.BigDecimal id) {
		log.debug("getting AudStepTemplateParameter instance with id: " + id);
		try {
			AudStepTemplateParameter instance = (AudStepTemplateParameter) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudStepTemplateParameter",
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

	public List<AudStepTemplateParameter> findByExample(
			AudStepTemplateParameter instance) {
		log.debug("finding AudStepTemplateParameter instance by example");
		try {
			List<AudStepTemplateParameter> results = (List<AudStepTemplateParameter>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudStepTemplateParameter")
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
