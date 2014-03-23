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
 * Home object for domain model class MdbLiteratureR.
 * @see com.cardiodx.db.waban.table.MdbLiteratureR
 * @author Hibernate Tools
 */
public class MdbLiteratureRHome {

	private static final Log log = LogFactory.getLog(MdbLiteratureRHome.class);

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

	public void persist(MdbLiteratureR transientInstance) {
		log.debug("persisting MdbLiteratureR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbLiteratureR instance) {
		log.debug("attaching dirty MdbLiteratureR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbLiteratureR instance) {
		log.debug("attaching clean MdbLiteratureR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbLiteratureR persistentInstance) {
		log.debug("deleting MdbLiteratureR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbLiteratureR merge(MdbLiteratureR detachedInstance) {
		log.debug("merging MdbLiteratureR instance");
		try {
			MdbLiteratureR result = (MdbLiteratureR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbLiteratureR findById(
			com.cardiodx.db.waban.table.MdbLiteratureRId id) {
		log.debug("getting MdbLiteratureR instance with id: " + id);
		try {
			MdbLiteratureR instance = (MdbLiteratureR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbLiteratureR", id);
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

	public List<MdbLiteratureR> findByExample(MdbLiteratureR instance) {
		log.debug("finding MdbLiteratureR instance by example");
		try {
			List<MdbLiteratureR> results = (List<MdbLiteratureR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbLiteratureR")
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
