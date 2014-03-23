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
 * Home object for domain model class MdbVariantR.
 * @see com.cardiodx.db.waban.table.MdbVariantR
 * @author Hibernate Tools
 */
public class MdbVariantRHome {

	private static final Log log = LogFactory.getLog(MdbVariantRHome.class);

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

	public void persist(MdbVariantR transientInstance) {
		log.debug("persisting MdbVariantR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbVariantR instance) {
		log.debug("attaching dirty MdbVariantR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbVariantR instance) {
		log.debug("attaching clean MdbVariantR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbVariantR persistentInstance) {
		log.debug("deleting MdbVariantR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbVariantR merge(MdbVariantR detachedInstance) {
		log.debug("merging MdbVariantR instance");
		try {
			MdbVariantR result = (MdbVariantR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbVariantR findById(com.cardiodx.db.waban.table.MdbVariantRId id) {
		log.debug("getting MdbVariantR instance with id: " + id);
		try {
			MdbVariantR instance = (MdbVariantR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbVariantR", id);
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

	public List<MdbVariantR> findByExample(MdbVariantR instance) {
		log.debug("finding MdbVariantR instance by example");
		try {
			List<MdbVariantR> results = (List<MdbVariantR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MdbVariantR")
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
