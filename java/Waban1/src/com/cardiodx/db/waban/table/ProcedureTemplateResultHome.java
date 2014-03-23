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
 * Home object for domain model class ProcedureTemplateResult.
 * @see com.cardiodx.db.waban.table.ProcedureTemplateResult
 * @author Hibernate Tools
 */
public class ProcedureTemplateResultHome {

	private static final Log log = LogFactory
			.getLog(ProcedureTemplateResultHome.class);

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

	public void persist(ProcedureTemplateResult transientInstance) {
		log.debug("persisting ProcedureTemplateResult instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProcedureTemplateResult instance) {
		log.debug("attaching dirty ProcedureTemplateResult instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProcedureTemplateResult instance) {
		log.debug("attaching clean ProcedureTemplateResult instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProcedureTemplateResult persistentInstance) {
		log.debug("deleting ProcedureTemplateResult instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProcedureTemplateResult merge(
			ProcedureTemplateResult detachedInstance) {
		log.debug("merging ProcedureTemplateResult instance");
		try {
			ProcedureTemplateResult result = (ProcedureTemplateResult) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProcedureTemplateResult findById(
			com.cardiodx.db.waban.table.ProcedureTemplateResultId id) {
		log.debug("getting ProcedureTemplateResult instance with id: " + id);
		try {
			ProcedureTemplateResult instance = (ProcedureTemplateResult) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ProcedureTemplateResult",
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

	public List<ProcedureTemplateResult> findByExample(
			ProcedureTemplateResult instance) {
		log.debug("finding ProcedureTemplateResult instance by example");
		try {
			List<ProcedureTemplateResult> results = (List<ProcedureTemplateResult>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProcedureTemplateResult")
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
