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
 * Home object for domain model class MdbStructureR.
 * @see com.cardiodx.db.waban.table.MdbStructureR
 * @author Hibernate Tools
 */
public class MdbStructureRHome {

	private static final Log log = LogFactory.getLog(MdbStructureRHome.class);

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

	public void persist(MdbStructureR transientInstance) {
		log.debug("persisting MdbStructureR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbStructureR instance) {
		log.debug("attaching dirty MdbStructureR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbStructureR instance) {
		log.debug("attaching clean MdbStructureR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbStructureR persistentInstance) {
		log.debug("deleting MdbStructureR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbStructureR merge(MdbStructureR detachedInstance) {
		log.debug("merging MdbStructureR instance");
		try {
			MdbStructureR result = (MdbStructureR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbStructureR findById(com.cardiodx.db.waban.table.MdbStructureRId id) {
		log.debug("getting MdbStructureR instance with id: " + id);
		try {
			MdbStructureR instance = (MdbStructureR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbStructureR", id);
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

	public List<MdbStructureR> findByExample(MdbStructureR instance) {
		log.debug("finding MdbStructureR instance by example");
		try {
			List<MdbStructureR> results = (List<MdbStructureR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.MdbStructureR")
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
