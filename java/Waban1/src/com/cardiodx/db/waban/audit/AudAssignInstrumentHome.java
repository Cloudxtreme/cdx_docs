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
 * Home object for domain model class AudAssignInstrument.
 * @see com.cardiodx.db.waban.audit.AudAssignInstrument
 * @author Hibernate Tools
 */
public class AudAssignInstrumentHome {

	private static final Log log = LogFactory
			.getLog(AudAssignInstrumentHome.class);

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

	public void persist(AudAssignInstrument transientInstance) {
		log.debug("persisting AudAssignInstrument instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudAssignInstrument instance) {
		log.debug("attaching dirty AudAssignInstrument instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudAssignInstrument instance) {
		log.debug("attaching clean AudAssignInstrument instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudAssignInstrument persistentInstance) {
		log.debug("deleting AudAssignInstrument instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudAssignInstrument merge(AudAssignInstrument detachedInstance) {
		log.debug("merging AudAssignInstrument instance");
		try {
			AudAssignInstrument result = (AudAssignInstrument) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudAssignInstrument findById(java.math.BigDecimal id) {
		log.debug("getting AudAssignInstrument instance with id: " + id);
		try {
			AudAssignInstrument instance = (AudAssignInstrument) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudAssignInstrument",
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

	public List<AudAssignInstrument> findByExample(AudAssignInstrument instance) {
		log.debug("finding AudAssignInstrument instance by example");
		try {
			List<AudAssignInstrument> results = (List<AudAssignInstrument>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.audit.AudAssignInstrument")
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
