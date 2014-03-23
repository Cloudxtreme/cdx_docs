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
 * Home object for domain model class InvestigatorProtocol.
 * @see com.cardiodx.db.waban.table.InvestigatorProtocol
 * @author Hibernate Tools
 */
public class InvestigatorProtocolHome {

	private static final Log log = LogFactory
			.getLog(InvestigatorProtocolHome.class);

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

	public void persist(InvestigatorProtocol transientInstance) {
		log.debug("persisting InvestigatorProtocol instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(InvestigatorProtocol instance) {
		log.debug("attaching dirty InvestigatorProtocol instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(InvestigatorProtocol instance) {
		log.debug("attaching clean InvestigatorProtocol instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(InvestigatorProtocol persistentInstance) {
		log.debug("deleting InvestigatorProtocol instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public InvestigatorProtocol merge(InvestigatorProtocol detachedInstance) {
		log.debug("merging InvestigatorProtocol instance");
		try {
			InvestigatorProtocol result = (InvestigatorProtocol) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public InvestigatorProtocol findById(
			com.cardiodx.db.waban.table.InvestigatorProtocolId id) {
		log.debug("getting InvestigatorProtocol instance with id: " + id);
		try {
			InvestigatorProtocol instance = (InvestigatorProtocol) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.InvestigatorProtocol",
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

	public List<InvestigatorProtocol> findByExample(
			InvestigatorProtocol instance) {
		log.debug("finding InvestigatorProtocol instance by example");
		try {
			List<InvestigatorProtocol> results = (List<InvestigatorProtocol>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.InvestigatorProtocol")
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
