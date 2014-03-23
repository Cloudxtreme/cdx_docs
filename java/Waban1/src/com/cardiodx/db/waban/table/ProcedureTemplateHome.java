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
 * Home object for domain model class ProcedureTemplate.
 * @see com.cardiodx.db.waban.table.ProcedureTemplate
 * @author Hibernate Tools
 */
public class ProcedureTemplateHome {

	private static final Log log = LogFactory
			.getLog(ProcedureTemplateHome.class);

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

	public void persist(ProcedureTemplate transientInstance) {
		log.debug("persisting ProcedureTemplate instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProcedureTemplate instance) {
		log.debug("attaching dirty ProcedureTemplate instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProcedureTemplate instance) {
		log.debug("attaching clean ProcedureTemplate instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProcedureTemplate persistentInstance) {
		log.debug("deleting ProcedureTemplate instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProcedureTemplate merge(ProcedureTemplate detachedInstance) {
		log.debug("merging ProcedureTemplate instance");
		try {
			ProcedureTemplate result = (ProcedureTemplate) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProcedureTemplate findById(java.math.BigDecimal id) {
		log.debug("getting ProcedureTemplate instance with id: " + id);
		try {
			ProcedureTemplate instance = (ProcedureTemplate) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ProcedureTemplate", id);
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

	public List<ProcedureTemplate> findByExample(ProcedureTemplate instance) {
		log.debug("finding ProcedureTemplate instance by example");
		try {
			List<ProcedureTemplate> results = (List<ProcedureTemplate>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProcedureTemplate")
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
