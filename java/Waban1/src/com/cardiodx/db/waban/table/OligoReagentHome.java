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
 * Home object for domain model class OligoReagent.
 * @see com.cardiodx.db.waban.table.OligoReagent
 * @author Hibernate Tools
 */
public class OligoReagentHome {

	private static final Log log = LogFactory.getLog(OligoReagentHome.class);

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

	public void persist(OligoReagent transientInstance) {
		log.debug("persisting OligoReagent instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(OligoReagent instance) {
		log.debug("attaching dirty OligoReagent instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OligoReagent instance) {
		log.debug("attaching clean OligoReagent instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(OligoReagent persistentInstance) {
		log.debug("deleting OligoReagent instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OligoReagent merge(OligoReagent detachedInstance) {
		log.debug("merging OligoReagent instance");
		try {
			OligoReagent result = (OligoReagent) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public OligoReagent findById(com.cardiodx.db.waban.table.OligoReagentId id) {
		log.debug("getting OligoReagent instance with id: " + id);
		try {
			OligoReagent instance = (OligoReagent) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.OligoReagent", id);
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

	public List<OligoReagent> findByExample(OligoReagent instance) {
		log.debug("finding OligoReagent instance by example");
		try {
			List<OligoReagent> results = (List<OligoReagent>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.OligoReagent")
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
