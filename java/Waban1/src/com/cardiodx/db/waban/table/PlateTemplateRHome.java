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
 * Home object for domain model class PlateTemplateR.
 * @see com.cardiodx.db.waban.table.PlateTemplateR
 * @author Hibernate Tools
 */
public class PlateTemplateRHome {

	private static final Log log = LogFactory.getLog(PlateTemplateRHome.class);

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

	public void persist(PlateTemplateR transientInstance) {
		log.debug("persisting PlateTemplateR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateTemplateR instance) {
		log.debug("attaching dirty PlateTemplateR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateTemplateR instance) {
		log.debug("attaching clean PlateTemplateR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateTemplateR persistentInstance) {
		log.debug("deleting PlateTemplateR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateTemplateR merge(PlateTemplateR detachedInstance) {
		log.debug("merging PlateTemplateR instance");
		try {
			PlateTemplateR result = (PlateTemplateR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateTemplateR findById(
			com.cardiodx.db.waban.table.PlateTemplateRId id) {
		log.debug("getting PlateTemplateR instance with id: " + id);
		try {
			PlateTemplateR instance = (PlateTemplateR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.PlateTemplateR", id);
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

	public List<PlateTemplateR> findByExample(PlateTemplateR instance) {
		log.debug("finding PlateTemplateR instance by example");
		try {
			List<PlateTemplateR> results = (List<PlateTemplateR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PlateTemplateR")
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
