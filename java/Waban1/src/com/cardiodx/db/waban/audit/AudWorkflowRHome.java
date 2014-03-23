package com.cardiodx.db.waban.audit;

// Generated Jul 14, 2011 1:33:02 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AudWorkflowR.
 * @see com.cardiodx.db.waban.audit.AudWorkflowR
 * @author Hibernate Tools
 */
public class AudWorkflowRHome {

	private static final Log log = LogFactory.getLog(AudWorkflowRHome.class);

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

	public void persist(AudWorkflowR transientInstance) {
		log.debug("persisting AudWorkflowR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AudWorkflowR instance) {
		log.debug("attaching dirty AudWorkflowR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AudWorkflowR instance) {
		log.debug("attaching clean AudWorkflowR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AudWorkflowR persistentInstance) {
		log.debug("deleting AudWorkflowR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AudWorkflowR merge(AudWorkflowR detachedInstance) {
		log.debug("merging AudWorkflowR instance");
		try {
			AudWorkflowR result = (AudWorkflowR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AudWorkflowR findById(com.cardiodx.db.waban.audit.AudWorkflowRId id) {
		log.debug("getting AudWorkflowR instance with id: " + id);
		try {
			AudWorkflowR instance = (AudWorkflowR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.audit.AudWorkflowR", id);
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

	public List<AudWorkflowR> findByExample(AudWorkflowR instance) {
		log.debug("finding AudWorkflowR instance by example");
		try {
			List<AudWorkflowR> results = (List<AudWorkflowR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.audit.AudWorkflowR")
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
