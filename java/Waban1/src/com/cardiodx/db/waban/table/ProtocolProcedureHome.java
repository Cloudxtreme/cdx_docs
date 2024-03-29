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
 * Home object for domain model class ProtocolProcedure.
 * @see com.cardiodx.db.waban.table.ProtocolProcedure
 * @author Hibernate Tools
 */
public class ProtocolProcedureHome {

	private static final Log log = LogFactory
			.getLog(ProtocolProcedureHome.class);

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

	public void persist(ProtocolProcedure transientInstance) {
		log.debug("persisting ProtocolProcedure instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProtocolProcedure instance) {
		log.debug("attaching dirty ProtocolProcedure instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProtocolProcedure instance) {
		log.debug("attaching clean ProtocolProcedure instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProtocolProcedure persistentInstance) {
		log.debug("deleting ProtocolProcedure instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProtocolProcedure merge(ProtocolProcedure detachedInstance) {
		log.debug("merging ProtocolProcedure instance");
		try {
			ProtocolProcedure result = (ProtocolProcedure) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProtocolProcedure findById(
			com.cardiodx.db.waban.table.ProtocolProcedureId id) {
		log.debug("getting ProtocolProcedure instance with id: " + id);
		try {
			ProtocolProcedure instance = (ProtocolProcedure) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.ProtocolProcedure", id);
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

	public List<ProtocolProcedure> findByExample(ProtocolProcedure instance) {
		log.debug("finding ProtocolProcedure instance by example");
		try {
			List<ProtocolProcedure> results = (List<ProtocolProcedure>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.ProtocolProcedure")
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
