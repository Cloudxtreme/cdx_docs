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
 * Home object for domain model class MdbExternalReferenceR.
 * @see com.cardiodx.db.waban.table.MdbExternalReferenceR
 * @author Hibernate Tools
 */
public class MdbExternalReferenceRHome {

	private static final Log log = LogFactory
			.getLog(MdbExternalReferenceRHome.class);

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

	public void persist(MdbExternalReferenceR transientInstance) {
		log.debug("persisting MdbExternalReferenceR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbExternalReferenceR instance) {
		log.debug("attaching dirty MdbExternalReferenceR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbExternalReferenceR instance) {
		log.debug("attaching clean MdbExternalReferenceR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbExternalReferenceR persistentInstance) {
		log.debug("deleting MdbExternalReferenceR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbExternalReferenceR merge(MdbExternalReferenceR detachedInstance) {
		log.debug("merging MdbExternalReferenceR instance");
		try {
			MdbExternalReferenceR result = (MdbExternalReferenceR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbExternalReferenceR findById(
			com.cardiodx.db.waban.table.MdbExternalReferenceRId id) {
		log.debug("getting MdbExternalReferenceR instance with id: " + id);
		try {
			MdbExternalReferenceR instance = (MdbExternalReferenceR) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.MdbExternalReferenceR",
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

	public List<MdbExternalReferenceR> findByExample(
			MdbExternalReferenceR instance) {
		log.debug("finding MdbExternalReferenceR instance by example");
		try {
			List<MdbExternalReferenceR> results = (List<MdbExternalReferenceR>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbExternalReferenceR")
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
