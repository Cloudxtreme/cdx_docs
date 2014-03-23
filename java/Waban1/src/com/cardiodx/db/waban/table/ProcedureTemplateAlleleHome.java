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
 * Home object for domain model class ProcedureTemplateAllele.
 * @see com.cardiodx.db.waban.table.ProcedureTemplateAllele
 * @author Hibernate Tools
 */
public class ProcedureTemplateAlleleHome {

	private static final Log log = LogFactory
			.getLog(ProcedureTemplateAlleleHome.class);

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

	public void persist(ProcedureTemplateAllele transientInstance) {
		log.debug("persisting ProcedureTemplateAllele instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProcedureTemplateAllele instance) {
		log.debug("attaching dirty ProcedureTemplateAllele instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProcedureTemplateAllele instance) {
		log.debug("attaching clean ProcedureTemplateAllele instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProcedureTemplateAllele persistentInstance) {
		log.debug("deleting ProcedureTemplateAllele instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProcedureTemplateAllele merge(
			ProcedureTemplateAllele detachedInstance) {
		log.debug("merging ProcedureTemplateAllele instance");
		try {
			ProcedureTemplateAllele result = (ProcedureTemplateAllele) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProcedureTemplateAllele findById(
			com.cardiodx.db.waban.table.ProcedureTemplateAlleleId id) {
		log.debug("getting ProcedureTemplateAllele instance with id: " + id);
		try {
			ProcedureTemplateAllele instance = (ProcedureTemplateAllele) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ProcedureTemplateAllele",
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

	public List<ProcedureTemplateAllele> findByExample(
			ProcedureTemplateAllele instance) {
		log.debug("finding ProcedureTemplateAllele instance by example");
		try {
			List<ProcedureTemplateAllele> results = (List<ProcedureTemplateAllele>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProcedureTemplateAllele")
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
