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
 * Home object for domain model class ProcedureTemplateR.
 * @see com.cardiodx.db.waban.table.ProcedureTemplateR
 * @author Hibernate Tools
 */
public class ProcedureTemplateRHome {

	private static final Log log = LogFactory
			.getLog(ProcedureTemplateRHome.class);

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

	public void persist(ProcedureTemplateR transientInstance) {
		log.debug("persisting ProcedureTemplateR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProcedureTemplateR instance) {
		log.debug("attaching dirty ProcedureTemplateR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProcedureTemplateR instance) {
		log.debug("attaching clean ProcedureTemplateR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProcedureTemplateR persistentInstance) {
		log.debug("deleting ProcedureTemplateR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProcedureTemplateR merge(ProcedureTemplateR detachedInstance) {
		log.debug("merging ProcedureTemplateR instance");
		try {
			ProcedureTemplateR result = (ProcedureTemplateR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProcedureTemplateR findById(
			com.cardiodx.db.waban.table.ProcedureTemplateRId id) {
		log.debug("getting ProcedureTemplateR instance with id: " + id);
		try {
			ProcedureTemplateR instance = (ProcedureTemplateR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ProcedureTemplateR",
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

	public List<ProcedureTemplateR> findByExample(ProcedureTemplateR instance) {
		log.debug("finding ProcedureTemplateR instance by example");
		try {
			List<ProcedureTemplateR> results = (List<ProcedureTemplateR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProcedureTemplateR")
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
