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
 * Home object for domain model class StepTemplateR.
 * @see com.cardiodx.db.waban.table.StepTemplateR
 * @author Hibernate Tools
 */
public class StepTemplateRHome {

	private static final Log log = LogFactory.getLog(StepTemplateRHome.class);

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

	public void persist(StepTemplateR transientInstance) {
		log.debug("persisting StepTemplateR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StepTemplateR instance) {
		log.debug("attaching dirty StepTemplateR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StepTemplateR instance) {
		log.debug("attaching clean StepTemplateR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StepTemplateR persistentInstance) {
		log.debug("deleting StepTemplateR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StepTemplateR merge(StepTemplateR detachedInstance) {
		log.debug("merging StepTemplateR instance");
		try {
			StepTemplateR result = (StepTemplateR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StepTemplateR findById(com.cardiodx.db.waban.table.StepTemplateRId id) {
		log.debug("getting StepTemplateR instance with id: " + id);
		try {
			StepTemplateR instance = (StepTemplateR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.StepTemplateR", id);
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

	public List<StepTemplateR> findByExample(StepTemplateR instance) {
		log.debug("finding StepTemplateR instance by example");
		try {
			List<StepTemplateR> results = (List<StepTemplateR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.StepTemplateR")
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
