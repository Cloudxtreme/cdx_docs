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
 * Home object for domain model class GeneInterprDefinition.
 * @see com.cardiodx.db.waban.table.GeneInterprDefinition
 * @author Hibernate Tools
 */
public class GeneInterprDefinitionHome {

	private static final Log log = LogFactory
			.getLog(GeneInterprDefinitionHome.class);

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

	public void persist(GeneInterprDefinition transientInstance) {
		log.debug("persisting GeneInterprDefinition instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(GeneInterprDefinition instance) {
		log.debug("attaching dirty GeneInterprDefinition instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GeneInterprDefinition instance) {
		log.debug("attaching clean GeneInterprDefinition instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(GeneInterprDefinition persistentInstance) {
		log.debug("deleting GeneInterprDefinition instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GeneInterprDefinition merge(GeneInterprDefinition detachedInstance) {
		log.debug("merging GeneInterprDefinition instance");
		try {
			GeneInterprDefinition result = (GeneInterprDefinition) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public GeneInterprDefinition findById(java.math.BigDecimal id) {
		log.debug("getting GeneInterprDefinition instance with id: " + id);
		try {
			GeneInterprDefinition instance = (GeneInterprDefinition) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.GeneInterprDefinition",
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

	public List<GeneInterprDefinition> findByExample(
			GeneInterprDefinition instance) {
		log.debug("finding GeneInterprDefinition instance by example");
		try {
			List<GeneInterprDefinition> results = (List<GeneInterprDefinition>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.GeneInterprDefinition")
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
