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
 * Home object for domain model class SubsidiaryR.
 * @see com.cardiodx.db.waban.table.SubsidiaryR
 * @author Hibernate Tools
 */
public class SubsidiaryRHome {

	private static final Log log = LogFactory.getLog(SubsidiaryRHome.class);

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

	public void persist(SubsidiaryR transientInstance) {
		log.debug("persisting SubsidiaryR instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SubsidiaryR instance) {
		log.debug("attaching dirty SubsidiaryR instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubsidiaryR instance) {
		log.debug("attaching clean SubsidiaryR instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SubsidiaryR persistentInstance) {
		log.debug("deleting SubsidiaryR instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubsidiaryR merge(SubsidiaryR detachedInstance) {
		log.debug("merging SubsidiaryR instance");
		try {
			SubsidiaryR result = (SubsidiaryR) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SubsidiaryR findById(com.cardiodx.db.waban.table.SubsidiaryRId id) {
		log.debug("getting SubsidiaryR instance with id: " + id);
		try {
			SubsidiaryR instance = (SubsidiaryR) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.SubsidiaryR", id);
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

	public List<SubsidiaryR> findByExample(SubsidiaryR instance) {
		log.debug("finding SubsidiaryR instance by example");
		try {
			List<SubsidiaryR> results = (List<SubsidiaryR>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.SubsidiaryR")
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
