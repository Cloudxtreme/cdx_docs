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
 * Home object for domain model class PlateTemplateWell.
 * @see com.cardiodx.db.waban.table.PlateTemplateWell
 * @author Hibernate Tools
 */
public class PlateTemplateWellHome {

	private static final Log log = LogFactory
			.getLog(PlateTemplateWellHome.class);

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

	public void persist(PlateTemplateWell transientInstance) {
		log.debug("persisting PlateTemplateWell instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PlateTemplateWell instance) {
		log.debug("attaching dirty PlateTemplateWell instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlateTemplateWell instance) {
		log.debug("attaching clean PlateTemplateWell instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PlateTemplateWell persistentInstance) {
		log.debug("deleting PlateTemplateWell instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlateTemplateWell merge(PlateTemplateWell detachedInstance) {
		log.debug("merging PlateTemplateWell instance");
		try {
			PlateTemplateWell result = (PlateTemplateWell) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PlateTemplateWell findById(
			com.cardiodx.db.waban.table.PlateTemplateWellId id) {
		log.debug("getting PlateTemplateWell instance with id: " + id);
		try {
			PlateTemplateWell instance = (PlateTemplateWell) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.PlateTemplateWell", id);
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

	public List<PlateTemplateWell> findByExample(PlateTemplateWell instance) {
		log.debug("finding PlateTemplateWell instance by example");
		try {
			List<PlateTemplateWell> results = (List<PlateTemplateWell>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PlateTemplateWell")
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
