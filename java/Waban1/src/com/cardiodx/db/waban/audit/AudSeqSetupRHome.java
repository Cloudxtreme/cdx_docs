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
 * Home object for domain model class AudSeqSetupR.
 * @see com.cardiodx.db.waban.audit.AudSeqSetupR
 * @author Hibernate Tools
 */
public class AudSeqSetupRHome {

	private static final Log log = LogFactory.getLog(AudSeqSetupRHome.class);

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

	public void persist(AudSeqSetupR transientInstance) {
		log.debug("persisting AudSeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudSeqSetupR instance) {
		log.debug("attaching dirty AudSeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudSeqSetupR instance) {
		log.debug("attaching clean AudSeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudSeqSetupR persistentInstance) {
		log.debug("deleting AudSeqSetupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudSeqSetupR merge(AudSeqSetupR detachedInstance) {
		log.debug("merging AudSeqSetupR instance");
		try {
			AudSeqSetupR result = (AudSeqSetupR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudSeqSetupR findById(com.cardiodx.db.waban.audit.AudSeqSetupRId id) {
		log.debug("getting AudSeqSetupR instance with id: " + id);
		try {
			AudSeqSetupR instance = (AudSeqSetupR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudSeqSetupR", id);
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

	public List<AudSeqSetupR> findByExample(AudSeqSetupR instance) {
		log.debug("finding AudSeqSetupR instance by example");
		try {
			List<AudSeqSetupR> results = (List<AudSeqSetupR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudSeqSetupR")
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
