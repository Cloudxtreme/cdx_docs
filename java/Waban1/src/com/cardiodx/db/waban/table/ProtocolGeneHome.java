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
 * Home object for domain model class ProtocolGene.
 * @see com.cardiodx.db.waban.table.ProtocolGene
 * @author Hibernate Tools
 */
public class ProtocolGeneHome {

	private static final Log log = LogFactory.getLog(ProtocolGeneHome.class);

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

	public void persist(ProtocolGene transientInstance) {
		log.debug("persisting ProtocolGene instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(ProtocolGene instance) {
		log.debug("attaching dirty ProtocolGene instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ProtocolGene instance) {
		log.debug("attaching clean ProtocolGene instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(ProtocolGene persistentInstance) {
		log.debug("deleting ProtocolGene instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ProtocolGene merge(ProtocolGene detachedInstance) {
		log.debug("merging ProtocolGene instance");
		try {
			ProtocolGene result = (ProtocolGene) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProtocolGene findById(java.math.BigDecimal id) {
		log.debug("getting ProtocolGene instance with id: " + id);
		try {
			ProtocolGene instance = (ProtocolGene) sessionFactory
					.getCurrentSession().get(
							"com.cardiodx.db.waban.table.ProtocolGene", id);
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

	public List<ProtocolGene> findByExample(ProtocolGene instance) {
		log.debug("finding ProtocolGene instance by example");
		try {
			List<ProtocolGene> results = (List<ProtocolGene>) sessionFactory
					.getCurrentSession()
					.createCriteria("com.cardiodx.db.waban.table.ProtocolGene")
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
