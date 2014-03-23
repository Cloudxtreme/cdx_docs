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
 * Home object for domain model class SeqSetupContainer.
 * @see com.cardiodx.db.waban.table.SeqSetupContainer
 * @author Hibernate Tools
 */
public class SeqSetupContainerHome {

	private static final Log log = LogFactory
			.getLog(SeqSetupContainerHome.class);

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

	public void persist(SeqSetupContainer transientInstance) {
		log.debug("persisting SeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SeqSetupContainer instance) {
		log.debug("attaching dirty SeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SeqSetupContainer instance) {
		log.debug("attaching clean SeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SeqSetupContainer persistentInstance) {
		log.debug("deleting SeqSetupContainer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SeqSetupContainer merge(SeqSetupContainer detachedInstance) {
		log.debug("merging SeqSetupContainer instance");
		try {
			SeqSetupContainer result = (SeqSetupContainer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SeqSetupContainer findById(java.math.BigDecimal id) {
		log.debug("getting SeqSetupContainer instance with id: " + id);
		try {
			SeqSetupContainer instance = (SeqSetupContainer) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.SeqSetupContainer", id);
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

	public List<SeqSetupContainer> findByExample(SeqSetupContainer instance) {
		log.debug("finding SeqSetupContainer instance by example");
		try {
			List<SeqSetupContainer> results = (List<SeqSetupContainer>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.SeqSetupContainer")
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
