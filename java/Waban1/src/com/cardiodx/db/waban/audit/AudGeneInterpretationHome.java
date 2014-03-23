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
 * Home object for domain model class AudGeneInterpretation.
 * @see com.cardiodx.db.waban.audit.AudGeneInterpretation
 * @author Hibernate Tools
 */
public class AudGeneInterpretationHome {

	private static final Log log = LogFactory
			.getLog(AudGeneInterpretationHome.class);

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

	public void persist(AudGeneInterpretation transientInstance) {
		log.debug("persisting AudGeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudGeneInterpretation instance) {
		log.debug("attaching dirty AudGeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudGeneInterpretation instance) {
		log.debug("attaching clean AudGeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudGeneInterpretation persistentInstance) {
		log.debug("deleting AudGeneInterpretation instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudGeneInterpretation merge(AudGeneInterpretation detachedInstance) {
		log.debug("merging AudGeneInterpretation instance");
		try {
			AudGeneInterpretation result = (AudGeneInterpretation) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudGeneInterpretation findById(java.math.BigDecimal id) {
		log.debug("getting AudGeneInterpretation instance with id: " + id);
		try {
			AudGeneInterpretation instance = (AudGeneInterpretation) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudGeneInterpretation",
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

	public List<AudGeneInterpretation> findByExample(
			AudGeneInterpretation instance) {
		log.debug("finding AudGeneInterpretation instance by example");
		try {
			List<AudGeneInterpretation> results = (List<AudGeneInterpretation>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudGeneInterpretation")
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
