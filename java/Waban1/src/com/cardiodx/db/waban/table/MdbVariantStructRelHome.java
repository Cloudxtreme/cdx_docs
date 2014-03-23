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
 * Home object for domain model class MdbVariantStructRel.
 * @see com.cardiodx.db.waban.table.MdbVariantStructRel
 * @author Hibernate Tools
 */
public class MdbVariantStructRelHome {

	private static final Log log = LogFactory
			.getLog(MdbVariantStructRelHome.class);

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

	public void persist(MdbVariantStructRel transientInstance) {
		log.debug("persisting MdbVariantStructRel instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MdbVariantStructRel instance) {
		log.debug("attaching dirty MdbVariantStructRel instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MdbVariantStructRel instance) {
		log.debug("attaching clean MdbVariantStructRel instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MdbVariantStructRel persistentInstance) {
		log.debug("deleting MdbVariantStructRel instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MdbVariantStructRel merge(MdbVariantStructRel detachedInstance) {
		log.debug("merging MdbVariantStructRel instance");
		try {
			MdbVariantStructRel result = (MdbVariantStructRel) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MdbVariantStructRel findById(java.math.BigDecimal id) {
		log.debug("getting MdbVariantStructRel instance with id: " + id);
		try {
			MdbVariantStructRel instance = (MdbVariantStructRel) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.MdbVariantStructRel",
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

	public List<MdbVariantStructRel> findByExample(MdbVariantStructRel instance) {
		log.debug("finding MdbVariantStructRel instance by example");
		try {
			List<MdbVariantStructRel> results = (List<MdbVariantStructRel>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.MdbVariantStructRel")
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
