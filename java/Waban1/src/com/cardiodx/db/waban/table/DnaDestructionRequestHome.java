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
 * Home object for domain model class DnaDestructionRequest.
 * @see com.cardiodx.db.waban.table.DnaDestructionRequest
 * @author Hibernate Tools
 */
public class DnaDestructionRequestHome {

	private static final Log log = LogFactory
			.getLog(DnaDestructionRequestHome.class);

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

	public void persist(DnaDestructionRequest transientInstance) {
		log.debug("persisting DnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaDestructionRequest instance) {
		log.debug("attaching dirty DnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaDestructionRequest instance) {
		log.debug("attaching clean DnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaDestructionRequest persistentInstance) {
		log.debug("deleting DnaDestructionRequest instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaDestructionRequest merge(DnaDestructionRequest detachedInstance) {
		log.debug("merging DnaDestructionRequest instance");
		try {
			DnaDestructionRequest result = (DnaDestructionRequest) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaDestructionRequest findById(java.math.BigDecimal id) {
		log.debug("getting DnaDestructionRequest instance with id: " + id);
		try {
			DnaDestructionRequest instance = (DnaDestructionRequest) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.DnaDestructionRequest",
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

	public List<DnaDestructionRequest> findByExample(
			DnaDestructionRequest instance) {
		log.debug("finding DnaDestructionRequest instance by example");
		try {
			List<DnaDestructionRequest> results = (List<DnaDestructionRequest>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.DnaDestructionRequest")
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
