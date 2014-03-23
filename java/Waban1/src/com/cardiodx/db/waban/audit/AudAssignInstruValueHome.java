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
 * Home object for domain model class AudAssignInstruValue.
 * @see com.cardiodx.db.waban.audit.AudAssignInstruValue
 * @author Hibernate Tools
 */
public class AudAssignInstruValueHome {

	private static final Log log = LogFactory
			.getLog(AudAssignInstruValueHome.class);

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

	public void persist(AudAssignInstruValue transientInstance) {
		log.debug("persisting AudAssignInstruValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudAssignInstruValue instance) {
		log.debug("attaching dirty AudAssignInstruValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudAssignInstruValue instance) {
		log.debug("attaching clean AudAssignInstruValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudAssignInstruValue persistentInstance) {
		log.debug("deleting AudAssignInstruValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudAssignInstruValue merge(AudAssignInstruValue detachedInstance) {
		log.debug("merging AudAssignInstruValue instance");
		try {
			AudAssignInstruValue result = (AudAssignInstruValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudAssignInstruValue findById(java.math.BigDecimal id) {
		log.debug("getting AudAssignInstruValue instance with id: " + id);
		try {
			AudAssignInstruValue instance = (AudAssignInstruValue) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudAssignInstruValue",
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

	public List<AudAssignInstruValue> findByExample(
			AudAssignInstruValue instance) {
		log.debug("finding AudAssignInstruValue instance by example");
		try {
			List<AudAssignInstruValue> results = (List<AudAssignInstruValue>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudAssignInstruValue")
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
