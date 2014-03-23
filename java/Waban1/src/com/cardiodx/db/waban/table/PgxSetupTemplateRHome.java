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
 * Home object for domain model class PgxSetupTemplateR.
 * @see com.cardiodx.db.waban.table.PgxSetupTemplateR
 * @author Hibernate Tools
 */
public class PgxSetupTemplateRHome {

	private static final Log log = LogFactory
			.getLog(PgxSetupTemplateRHome.class);

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

	public void persist(PgxSetupTemplateR transientInstance) {
		log.debug("persisting PgxSetupTemplateR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PgxSetupTemplateR instance) {
		log.debug("attaching dirty PgxSetupTemplateR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PgxSetupTemplateR instance) {
		log.debug("attaching clean PgxSetupTemplateR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PgxSetupTemplateR persistentInstance) {
		log.debug("deleting PgxSetupTemplateR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PgxSetupTemplateR merge(PgxSetupTemplateR detachedInstance) {
		log.debug("merging PgxSetupTemplateR instance");
		try {
			PgxSetupTemplateR result = (PgxSetupTemplateR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PgxSetupTemplateR findById(
			com.cardiodx.db.waban.table.PgxSetupTemplateRId id) {
		log.debug("getting PgxSetupTemplateR instance with id: " + id);
		try {
			PgxSetupTemplateR instance = (PgxSetupTemplateR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.PgxSetupTemplateR", id);
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

	public List<PgxSetupTemplateR> findByExample(PgxSetupTemplateR instance) {
		log.debug("finding PgxSetupTemplateR instance by example");
		try {
			List<PgxSetupTemplateR> results = (List<PgxSetupTemplateR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.PgxSetupTemplateR")
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
