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
 * Home object for domain model class MasterMixDilution.
 * @see com.cardiodx.db.waban.table.MasterMixDilution
 * @author Hibernate Tools
 */
public class MasterMixDilutionHome {

	private static final Log log = LogFactory
			.getLog(MasterMixDilutionHome.class);

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

	public void persist(MasterMixDilution transientInstance) {
		log.debug("persisting MasterMixDilution instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MasterMixDilution instance) {
		log.debug("attaching dirty MasterMixDilution instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MasterMixDilution instance) {
		log.debug("attaching clean MasterMixDilution instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MasterMixDilution persistentInstance) {
		log.debug("deleting MasterMixDilution instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MasterMixDilution merge(MasterMixDilution detachedInstance) {
		log.debug("merging MasterMixDilution instance");
		try {
			MasterMixDilution result = (MasterMixDilution) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MasterMixDilution findById(
			com.cardiodx.db.waban.table.MasterMixDilutionId id) {
		log.debug("getting MasterMixDilution instance with id: " + id);
		try {
			MasterMixDilution instance = (MasterMixDilution) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.MasterMixDilution", id);
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

	public List<MasterMixDilution> findByExample(MasterMixDilution instance) {
		log.debug("finding MasterMixDilution instance by example");
		try {
			List<MasterMixDilution> results = (List<MasterMixDilution>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MasterMixDilution")
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
