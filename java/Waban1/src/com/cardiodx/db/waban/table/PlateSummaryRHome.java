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
 * Home object for domain model class PlateSummaryR.
 * @see com.cardiodx.db.waban.table.PlateSummaryR
 * @author Hibernate Tools
 */
public class PlateSummaryRHome {

	private static final Log log = LogFactory.getLog(PlateSummaryRHome.class);

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

	public void persist(PlateSummaryR transientInstance) {
		log.debug("persisting PlateSummaryR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateSummaryR instance) {
		log.debug("attaching dirty PlateSummaryR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateSummaryR instance) {
		log.debug("attaching clean PlateSummaryR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateSummaryR persistentInstance) {
		log.debug("deleting PlateSummaryR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateSummaryR merge(PlateSummaryR detachedInstance) {
		log.debug("merging PlateSummaryR instance");
		try {
			PlateSummaryR result = (PlateSummaryR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateSummaryR findById(com.cardiodx.db.waban.table.PlateSummaryRId id) {
		log.debug("getting PlateSummaryR instance with id: " + id);
		try {
			PlateSummaryR instance = (PlateSummaryR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PlateSummaryR", id);
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

	public List<PlateSummaryR> findByExample(PlateSummaryR instance) {
		log.debug("finding PlateSummaryR instance by example");
		try {
			List<PlateSummaryR> results = (List<PlateSummaryR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.PlateSummaryR")
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
