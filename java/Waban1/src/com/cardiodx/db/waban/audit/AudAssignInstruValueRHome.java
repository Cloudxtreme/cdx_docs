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
 * Home object for domain model class AudAssignInstruValueR.
 * @see com.cardiodx.db.waban.audit.AudAssignInstruValueR
 * @author Hibernate Tools
 */
public class AudAssignInstruValueRHome {

	private static final Log log = LogFactory
			.getLog(AudAssignInstruValueRHome.class);

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

	public void persist(AudAssignInstruValueR transientInstance) {
		log.debug("persisting AudAssignInstruValueR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudAssignInstruValueR instance) {
		log.debug("attaching dirty AudAssignInstruValueR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudAssignInstruValueR instance) {
		log.debug("attaching clean AudAssignInstruValueR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudAssignInstruValueR persistentInstance) {
		log.debug("deleting AudAssignInstruValueR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudAssignInstruValueR merge(AudAssignInstruValueR detachedInstance) {
		log.debug("merging AudAssignInstruValueR instance");
		try {
			AudAssignInstruValueR result = (AudAssignInstruValueR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudAssignInstruValueR findById(
			com.cardiodx.db.waban.audit.AudAssignInstruValueRId id) {
		log.debug("getting AudAssignInstruValueR instance with id: " + id);
		try {
			AudAssignInstruValueR instance = (AudAssignInstruValueR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.audit.AudAssignInstruValueR",
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

	public List<AudAssignInstruValueR> findByExample(
			AudAssignInstruValueR instance) {
		log.debug("finding AudAssignInstruValueR instance by example");
		try {
			List<AudAssignInstruValueR> results = (List<AudAssignInstruValueR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudAssignInstruValueR")
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
