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
 * Home object for domain model class PcrSetupR.
 * @see com.cardiodx.db.waban.table.PcrSetupR
 * @author Hibernate Tools
 */
public class PcrSetupRHome {

	private static final Log log = LogFactory.getLog(PcrSetupRHome.class);

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

	public void persist(PcrSetupR transientInstance) {
		log.debug("persisting PcrSetupR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PcrSetupR instance) {
		log.debug("attaching dirty PcrSetupR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PcrSetupR instance) {
		log.debug("attaching clean PcrSetupR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PcrSetupR persistentInstance) {
		log.debug("deleting PcrSetupR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PcrSetupR merge(PcrSetupR detachedInstance) {
		log.debug("merging PcrSetupR instance");
		try {
			PcrSetupR result = (PcrSetupR) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PcrSetupR findById(com.cardiodx.db.waban.table.PcrSetupRId id) {
		log.debug("getting PcrSetupR instance with id: " + id);
		try {
			PcrSetupR instance = (PcrSetupR) sessionFactory.getCurrentSession()
					.get("com.cardiodx.db.waban.table.PcrSetupR", id);
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

	public List<PcrSetupR> findByExample(PcrSetupR instance) {
		log.debug("finding PcrSetupR instance by example");
		try {
			List<PcrSetupR> results = (List<PcrSetupR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.PcrSetupR")
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
