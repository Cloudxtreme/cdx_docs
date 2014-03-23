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
 * Home object for domain model class DnaDestructionRequestR.
 * @see com.cardiodx.db.waban.table.DnaDestructionRequestR
 * @author Hibernate Tools
 */
public class DnaDestructionRequestRHome {

	private static final Log log = LogFactory
			.getLog(DnaDestructionRequestRHome.class);

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

	public void persist(DnaDestructionRequestR transientInstance) {
		log.debug("persisting DnaDestructionRequestR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(DnaDestructionRequestR instance) {
		log.debug("attaching dirty DnaDestructionRequestR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DnaDestructionRequestR instance) {
		log.debug("attaching clean DnaDestructionRequestR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(DnaDestructionRequestR persistentInstance) {
		log.debug("deleting DnaDestructionRequestR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public DnaDestructionRequestR merge(DnaDestructionRequestR detachedInstance) {
		log.debug("merging DnaDestructionRequestR instance");
		try {
			DnaDestructionRequestR result = (DnaDestructionRequestR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DnaDestructionRequestR findById(
			com.cardiodx.db.waban.table.DnaDestructionRequestRId id) {
		log.debug("getting DnaDestructionRequestR instance with id: " + id);
		try {
			DnaDestructionRequestR instance = (DnaDestructionRequestR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.DnaDestructionRequestR",
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

	public List<DnaDestructionRequestR> findByExample(
			DnaDestructionRequestR instance) {
		log.debug("finding DnaDestructionRequestR instance by example");
		try {
			List<DnaDestructionRequestR> results = (List<DnaDestructionRequestR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.DnaDestructionRequestR")
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
