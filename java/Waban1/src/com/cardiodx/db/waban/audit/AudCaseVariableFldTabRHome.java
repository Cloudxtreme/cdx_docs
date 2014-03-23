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
 * Home object for domain model class AudCaseVariableFldTabR.
 * @see com.cardiodx.db.waban.audit.AudCaseVariableFldTabR
 * @author Hibernate Tools
 */
public class AudCaseVariableFldTabRHome {

	private static final Log log = LogFactory
			.getLog(AudCaseVariableFldTabRHome.class);

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

	public void persist(AudCaseVariableFldTabR transientInstance) {
		log.debug("persisting AudCaseVariableFldTabR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudCaseVariableFldTabR instance) {
		log.debug("attaching dirty AudCaseVariableFldTabR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudCaseVariableFldTabR instance) {
		log.debug("attaching clean AudCaseVariableFldTabR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudCaseVariableFldTabR persistentInstance) {
		log.debug("deleting AudCaseVariableFldTabR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudCaseVariableFldTabR merge(AudCaseVariableFldTabR detachedInstance) {
		log.debug("merging AudCaseVariableFldTabR instance");
		try {
			AudCaseVariableFldTabR result = (AudCaseVariableFldTabR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudCaseVariableFldTabR findById(
			com.cardiodx.db.waban.audit.AudCaseVariableFldTabRId id) {
		log.debug("getting AudCaseVariableFldTabR instance with id: " + id);
		try {
			AudCaseVariableFldTabR instance = (AudCaseVariableFldTabR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudCaseVariableFldTabR",
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

	public List<AudCaseVariableFldTabR> findByExample(
			AudCaseVariableFldTabR instance) {
		log.debug("finding AudCaseVariableFldTabR instance by example");
		try {
			List<AudCaseVariableFldTabR> results = (List<AudCaseVariableFldTabR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudCaseVariableFldTabR")
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
