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
 * Home object for domain model class StepTemplateValue.
 * @see com.cardiodx.db.waban.table.StepTemplateValue
 * @author Hibernate Tools
 */
public class StepTemplateValueHome {

	private static final Log log = LogFactory
			.getLog(StepTemplateValueHome.class);

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

	public void persist(StepTemplateValue transientInstance) {
		log.debug("persisting StepTemplateValue instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StepTemplateValue instance) {
		log.debug("attaching dirty StepTemplateValue instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StepTemplateValue instance) {
		log.debug("attaching clean StepTemplateValue instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StepTemplateValue persistentInstance) {
		log.debug("deleting StepTemplateValue instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StepTemplateValue merge(StepTemplateValue detachedInstance) {
		log.debug("merging StepTemplateValue instance");
		try {
			StepTemplateValue result = (StepTemplateValue) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StepTemplateValue findById(
			com.cardiodx.db.waban.table.StepTemplateValueId id) {
		log.debug("getting StepTemplateValue instance with id: " + id);
		try {
			StepTemplateValue instance = (StepTemplateValue) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.StepTemplateValue", id);
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

	public List<StepTemplateValue> findByExample(StepTemplateValue instance) {
		log.debug("finding StepTemplateValue instance by example");
		try {
			List<StepTemplateValue> results = (List<StepTemplateValue>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.StepTemplateValue")
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