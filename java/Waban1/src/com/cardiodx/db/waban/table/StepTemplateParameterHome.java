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
 * Home object for domain model class StepTemplateParameter.
 * @see com.cardiodx.db.waban.table.StepTemplateParameter
 * @author Hibernate Tools
 */
public class StepTemplateParameterHome {

	private static final Log log = LogFactory
			.getLog(StepTemplateParameterHome.class);

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

	public void persist(StepTemplateParameter transientInstance) {
		log.debug("persisting StepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(StepTemplateParameter instance) {
		log.debug("attaching dirty StepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(StepTemplateParameter instance) {
		log.debug("attaching clean StepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(StepTemplateParameter persistentInstance) {
		log.debug("deleting StepTemplateParameter instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public StepTemplateParameter merge(StepTemplateParameter detachedInstance) {
		log.debug("merging StepTemplateParameter instance");
		try {
			StepTemplateParameter result = (StepTemplateParameter) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public StepTemplateParameter findById(
			com.cardiodx.db.waban.table.StepTemplateParameterId id) {
		log.debug("getting StepTemplateParameter instance with id: " + id);
		try {
			StepTemplateParameter instance = (StepTemplateParameter) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.StepTemplateParameter",
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

	public List<StepTemplateParameter> findByExample(
			StepTemplateParameter instance) {
		log.debug("finding StepTemplateParameter instance by example");
		try {
			List<StepTemplateParameter> results = (List<StepTemplateParameter>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.StepTemplateParameter")
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
