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
 * Home object for domain model class AnonymizedLabAccessionNo.
 * @see com.cardiodx.db.waban.table.AnonymizedLabAccessionNo
 * @author Hibernate Tools
 */
public class AnonymizedLabAccessionNoHome {

	private static final Log log = LogFactory
			.getLog(AnonymizedLabAccessionNoHome.class);

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

	public void persist(AnonymizedLabAccessionNo transientInstance) {
		log.debug("persisting AnonymizedLabAccessionNo instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(AnonymizedLabAccessionNo instance) {
		log.debug("attaching dirty AnonymizedLabAccessionNo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AnonymizedLabAccessionNo instance) {
		log.debug("attaching clean AnonymizedLabAccessionNo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(AnonymizedLabAccessionNo persistentInstance) {
		log.debug("deleting AnonymizedLabAccessionNo instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AnonymizedLabAccessionNo merge(
			AnonymizedLabAccessionNo detachedInstance) {
		log.debug("merging AnonymizedLabAccessionNo instance");
		try {
			AnonymizedLabAccessionNo result = (AnonymizedLabAccessionNo) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AnonymizedLabAccessionNo findById(java.math.BigDecimal id) {
		log.debug("getting AnonymizedLabAccessionNo instance with id: " + id);
		try {
			AnonymizedLabAccessionNo instance = (AnonymizedLabAccessionNo) sessionFactory
					.getCurrentSession()
					.get("com.cardiodx.db.waban.table.AnonymizedLabAccessionNo",
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

	public List<AnonymizedLabAccessionNo> findByExample(
			AnonymizedLabAccessionNo instance) {
		log.debug("finding AnonymizedLabAccessionNo instance by example");
		try {
			List<AnonymizedLabAccessionNo> results = (List<AnonymizedLabAccessionNo>) sessionFactory
					.getCurrentSession()
					.createCriteria(
							"com.cardiodx.db.waban.table.AnonymizedLabAccessionNo")
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
