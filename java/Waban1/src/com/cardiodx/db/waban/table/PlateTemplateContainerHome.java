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
 * Home object for domain model class PlateTemplateContainer.
 * @see com.cardiodx.db.waban.table.PlateTemplateContainer
 * @author Hibernate Tools
 */
public class PlateTemplateContainerHome {

	private static final Log log = LogFactory
			.getLog(PlateTemplateContainerHome.class);

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

	public void persist(PlateTemplateContainer transientInstance) {
		log.debug("persisting PlateTemplateContainer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateTemplateContainer instance) {
		log.debug("attaching dirty PlateTemplateContainer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateTemplateContainer instance) {
		log.debug("attaching clean PlateTemplateContainer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateTemplateContainer persistentInstance) {
		log.debug("deleting PlateTemplateContainer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateTemplateContainer merge(PlateTemplateContainer detachedInstance) {
		log.debug("merging PlateTemplateContainer instance");
		try {
			PlateTemplateContainer result = (PlateTemplateContainer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateTemplateContainer findById(
			com.cardiodx.db.waban.table.PlateTemplateContainerId id) {
		log.debug("getting PlateTemplateContainer instance with id: " + id);
		try {
			PlateTemplateContainer instance = (PlateTemplateContainer) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.PlateTemplateContainer",
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

	public List<PlateTemplateContainer> findByExample(
			PlateTemplateContainer instance) {
		log.debug("finding PlateTemplateContainer instance by example");
		try {
			List<PlateTemplateContainer> results = (List<PlateTemplateContainer>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PlateTemplateContainer")
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
